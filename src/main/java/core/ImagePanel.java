package core;

import helper.PropertiesHelper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImagePanel extends JLayeredPane {

    private final String defaultPicKeyPage = "default";
    private Boolean lockFade = false;
    private String currentBackgroundKeyPage = null;

    //FIXME
    int x, y;

    public static ImagePanel imagePanel;

    private static final int PREF_W = 300;
    private static final int PREF_H = PREF_W;
    private static final Color BACKGROUND = Color.WHITE;
    private ArrayList<ImageObject> images = new ArrayList<>();

    public ImagePanel() {
        // addMouseMotionListener(new MouseMotionHandler());
        try {
            BufferedImage img = ImageIO.read(new File(PropertiesHelper.getString("apps.default.img.path")));
            addImage(img, "default", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBackground(BACKGROUND);
    }

    public static ImagePanel getInstance() {
        if (imagePanel == null) {
            imagePanel = new ImagePanel();
        }
        return imagePanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ImageObject image : images) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, image.getOpacity()));
            g2d.drawImage(image.getImage(), image.getPos_x(), image.getPos_y(), this);
        }

        // not needed
        /*ImageObject imageObject = findPointImage(images);

        if (imageObject != null) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(imageObject.getImage(), x, y, this);

            // update
            images.remove(imageObject);
            imageObject.setPos_x(x);
            imageObject.setPos_y(y);
            images.add(imageObject);
        }*/
    }

    public void clearImages() {
        images.clear();
        repaint();
    }

    public void removeImage(String referenceKey) {
        ImageObject o = find(referenceKey);
        images.remove(o);
        repaint();
    }

    public void addImage(BufferedImage image, String referenceKey) {
        addImage(image, referenceKey, false);
    }

    public void addImage(BufferedImage image, String referenceKey, Boolean hide) {
        if (hide) {
            addImage(image, 0, 0, referenceKey, 0.00f);
        } else {
            addImage(image, 0, 0, referenceKey, 1.0f);
        }
    }

    public void addImage(BufferedImage image, Integer pos_x, Integer pos_y, String referenceKey, Float opacity) {
        addImage(image, pos_x, pos_y, referenceKey, opacity, false);
    }

    public void addImage(BufferedImage image, Integer pos_x, Integer pos_y, String referenceKey, Float opacity, Boolean isMovable) {
        ImageObject o = new ImageObject(image, pos_x, pos_y, referenceKey, opacity, isMovable);
        images.add(o);
        setDefaultBackgroundKey(referenceKey);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public ImageObject find(String referenceKey) {
        // we can use hashmap but who cares lol

        for (ImageObject image : images) {
            if (referenceKey.equals(image.getReferenceKey())) {
                return image;
            }
        }
        return find(defaultPicKeyPage);
    }

    /*public void triggerFadeImageEvent(String referenceKey, Integer fadeDelay, ImageObject.Command command) {
        triggerFadeImageEvent(referenceKey, fadeDelay, command, false);
    }*/

    public void triggerFadeImageEvent(Integer fadeDelay, ImageObject.Command command) {
        triggerFadeImageEvent(currentBackgroundKeyPage, fadeDelay, command, false);
    }

    public void triggerFadeImageEvent(Integer fadeDelay, ImageObject.Command command, Boolean updateBackground) {
        triggerFadeImageEvent(currentBackgroundKeyPage, fadeDelay, command, updateBackground);
    }

    // todo: Support await
    public void triggerFadeImageEvent(String referenceKey, Integer fadeDelay, ImageObject.Command command, Boolean updateBackground) {
        if (updateBackground) {
            setCurrentBackgroundKeyPage(referenceKey);
        }
        ImageObject img = find(referenceKey);
        ImageObject tempImg = img;
        // FIXME: FIX THIS STUPIDITY
        tempImg.setFadeDelay(fadeDelay);
        tempImg.setCommand(command);
        updateDataDirectlyToArray(img, tempImg);
        processFadeImages(tempImg);
    }

    /*// FIXME: let make it work now before we actually do refactor
    public class MouseMotionHandler extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
        }
    }*/

    // not needed for now
    /*private ImageObject findPointImage(ArrayList<ImageObject> list) {
        java.util.List<ImageObject> imageToMove = list.stream()
                .filter(ImageObject::getMovable)
                .collect(Collectors.toList());

        ImageObject toReturn = null;
        ImageObject nearest = null;

        if (!imageToMove.isEmpty()) {
            for (ImageObject io : imageToMove) {
                if (nearest == null) {
                    nearest = io;
                } else {
                    nearest = Helper.getNearest(x, y, nearest, io);
                }
            }
        }

        if (nearest != null && Point2D.distance(x, y, nearest.getPos_x(), nearest.getPos_y()) < 200) {
            toReturn = nearest;
        }

        return toReturn;
    }*/

    private void processFadeImages(ImageObject fadeImage) {

        ActionListener fadeListener = new ActionListener() {

            float transparency = fadeImage.getOpacity();
            float offset = .01f;

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = images.indexOf(fadeImage);

                if (ImageObject.Command.FADE_OUT.equals(fadeImage.getCommand())) {
                    if (transparency >= 0.00f) {
                        transparency -= offset;
                    }
                    if (transparency <= 0f) {
                        images.get(index).setOpacity(0.00f);
                        images.get(index).setCommand(ImageObject.Command.DEFAULT);
                    }
                } else if (ImageObject.Command.FADE_IN.equals(fadeImage.getCommand())) {
                    if (transparency <= 1.00f) {
                        transparency += offset;
                    }
                    if (transparency >= 1.00f) {
                        images.get(index).setOpacity(1.00f);
                        images.get(index).setCommand(ImageObject.Command.DEFAULT);
                    }
                }
                // don't render illegal alpha
                if (transparency >= 0.01f && transparency <= 0.99f) {
                    images.get(index).setOpacity(transparency);
                } else {
                    ((Timer) e.getSource()).stop();
                }
                repaint();
            }
        };
        Timer timer = new Timer(fadeImage.getFadeDelay(), fadeListener);
        timer.start();
    }

    private void updateDataDirectlyToArray(ImageObject persistance, ImageObject update) {
        images.remove(persistance);
        images.add(update);
    }

    public void setDefaultBackgroundKey(String referenceKey) {
        if (currentBackgroundKeyPage == null && !defaultPicKeyPage.equals(referenceKey)) {
            setCurrentBackgroundKeyPage(referenceKey);
        }
    }

    private void setCurrentBackgroundKeyPage(String referenceKey) {
        currentBackgroundKeyPage = referenceKey;
    }

}

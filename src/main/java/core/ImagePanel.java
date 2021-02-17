package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class ImagePanel extends JPanel {

    //FIXME
    int x, y;

    public static ImagePanel imagePanel;

    private static final int PREF_W = 300;
    private static final int PREF_H = PREF_W;
    private static final Color BACKGROUND = Color.WHITE;
    private ArrayList<ImageObject> images = new ArrayList<>();

    public ImagePanel() {
        addMouseMotionListener(new MouseMotionHandler());
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
            g.drawImage(image.getImage(), image.getPos_x(), image.getPos_y(), this);
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

    public void addImage(Image image, String referenceKey) {
        addImage(image, 0, 0, referenceKey, false);
    }

    public void addImage(Image image, Integer pos_x, Integer pos_y, String referenceKey) {
        addImage(image, pos_x, pos_y, referenceKey, false);
    }

    public void addImage(Image image, Integer pos_x, Integer pos_y, String referenceKey, Boolean isMovable) {
        ImageObject o = new ImageObject(image, pos_x, pos_y, referenceKey, isMovable);
        images.add(o);
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

        return null;
    }

    // FIXME: let make it work now before we actually do refactor
    public class MouseMotionHandler extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
        }
    }

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
}

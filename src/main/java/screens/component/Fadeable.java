package screens.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Fadeable {

    private JComponent jComponent;
    private FadebleSequence fadebleSequence;
    private float opacity = 1.00f;
    private Map<String, Object> args = new HashMap<>();
    private Object promiseObject;

    public Fadeable(JComponent jComponent, FadebleSequence fadebleSequence) {
        this.jComponent = jComponent;
        this.fadebleSequence = fadebleSequence;
    }

    public void fade() {
        int delay = (Integer) args.get("delay");
        String command = (String) args.get("command");

        ActionListener fadeListener = new ActionListener() {

            float transparency = opacity;
            float offset = .01f;
            // specialize for fadeswap
            boolean fadeSwapDone = false;
            boolean fadeSwapRecurring = false;
            boolean doneLoadPromiseObject = false;

            @Override
            public void actionPerformed(ActionEvent e) {

                // System.out.println(opacity);

                switch (command) {
                    case "fadeout":
                        if (!doneLoadPromiseObject) {
                            fadebleSequence.execute(promiseObject);
                            doneLoadPromiseObject = true;
                        }
                        if (transparency >= 0.00f) {
                            transparency -= offset;
                        }
                        if (transparency <= 0f) {
                            opacity = 0.00f;
                        }
                        break;
                    case "fadein":
                        if (!doneLoadPromiseObject) {
                            fadebleSequence.execute(promiseObject);
                            doneLoadPromiseObject = true;
                        }
                        if (transparency <= 1.00f) {
                            transparency += offset;
                        }
                        if (transparency >= 1.00f) {
                            opacity = 1.00f;
                        }
                        break;
                    case "fadeswap":
                        if (transparency > 0.02f && !fadeSwapRecurring) {
                            transparency -= offset;
                        } else {
                            if (!doneLoadPromiseObject) {
                                fadebleSequence.execute(promiseObject);
                                doneLoadPromiseObject = true;
                            }
                            if (transparency <= 1.00f) {
                                transparency += offset;
                            } else {
                                fadeSwapDone = true;
                                opacity = 1.00f;
                            }
                            fadeSwapRecurring = true;
                        }
                        break;
                }
                // don't render illegal alpha
                if (transparency >= 0.01f && transparency <= 0.99f) {
                    opacity = transparency;
                } else if (fadeSwapDone) {
                    terminateRender(((Timer) e.getSource()));
                } else {
                    terminateRender(((Timer) e.getSource()));
                }
                jComponent.repaint();
            }
        };
        Timer timer = new Timer(delay, fadeListener);
        timer.start();
    }

    private void terminateRender(Timer timer) {
        timer.stop();
    }

    public boolean isHidden() {
        // safety
        return opacity <= 0.05f;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public void addArgs(String key, Object value) {
        args.put(key, value);
    }

    public void loadPromiseObject(Object object) {
        promiseObject = object;
    }


}

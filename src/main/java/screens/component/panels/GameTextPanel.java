package screens.component.panels;

import core.ScriptReader;
import core.objects.ScriptObject;
import screens.component.labels.GameTextLabel;
import screens.component.textarea.GameTextArea;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameTextPanel extends FadePanel {

    private static GameTextLabel playerLabel;
    private static GameTextArea conversationLabel;
    private ArrayList<ScriptObject> scripts;
    // is it okay like this?
    private static String currentSpeaker = null;

    protected int act = 1;
    protected int scene = 1;
    protected int itr = 0;

    public GameTextPanel() {
        super(new BorderLayout());
        playerLabel = new GameTextLabel();
        conversationLabel = new GameTextArea();
        PanelBuilder.create().setBackgroundColor(Color.LIGHT_GRAY).build(this);

        // new game TODO: don't hard code
        scripts = ScriptReader.loadScript(act, scene);

        add(playerLabel, BorderLayout.PAGE_START);
        add(conversationLabel, BorderLayout.CENTER);

        conversationLabel.addMouseListener(new GameTextBoxAdapter(this));
    }

    private static class GameTextBoxAdapter extends MouseAdapter {

        private GameTextPanel gameTextPanel;

        private GameTextBoxAdapter(GameTextPanel gameTextPanel) {
            this.gameTextPanel = gameTextPanel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (gameTextPanel.itr < gameTextPanel.scripts.size()) {
                ScriptObject sco = gameTextPanel.scripts.get(gameTextPanel.itr);
                if (currentSpeaker == null || !currentSpeaker.equals(sco.getActor())) {
                    currentSpeaker = sco.getActor();
                    playerLabel.loadPromiseObject(currentSpeaker);
                    playerLabel.fade(1, "fadeswap");
                }
                conversationLabel.loadPromiseObject(sco.getConv());
                conversationLabel.fade(1, "fadeswap");
                gameTextPanel.itr++;
            } else {
                // change scene
                // gameTextPanel.itr= 0;
                // gameTextPanel.fade(1, "fadeswap");
            }
        }
    }

    @Override
    protected void fadebleSequence(Object o) {
    }
}

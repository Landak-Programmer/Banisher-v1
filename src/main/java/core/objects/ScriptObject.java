package core.objects;

public class ScriptObject {

    private String actor;
    private String conv;

    public ScriptObject(String actor, String conv) {
        this.actor = actor;
        this.conv = conv;
    }

    public String getActor() {
        return actor;
    }

    public String getConv() {
        return conv;
    }
}

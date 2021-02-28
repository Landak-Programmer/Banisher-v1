package core;

import core.objects.ScriptObject;
import helper.FileReader;
import helper.PropertiesHelper;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class ScriptReader {

    /**
     * This will load script from resources packages
     * <p>
     * path: src/main/resources/script
     * filename: scene-x-y
     * where x is act number
     * and y is scene number
     */
    public static ArrayList<ScriptObject> loadScript(int act, int scene) {
        String path = PropertiesHelper.getString("apps.script.base.path");
        String fileName = String.format("scene-%s-%s", act, scene);
        return scriptExtractor(Objects.requireNonNull(FileReader.readFile(path, fileName)));
    }

    public static ArrayList<ScriptObject> loadNextScript(int act, int scene) {
        scene += 1;
        String path = PropertiesHelper.getString("apps.script.base.path");
        String fileName = String.format("scene-%s-%s", act, scene);
        try {
            return scriptExtractor(FileReader.readFileIgnoreCatch(path, fileName));
        } catch (FileNotFoundException e) {
            // no next scene - jump to next act
        }

        scene = 1;
        act += 1;
        fileName = String.format("scene-%s-%s", act, scene);

        return scriptExtractor(Objects.requireNonNull(FileReader.readFile(path, fileName)));
    }


    private static ArrayList<ScriptObject> scriptExtractor(ArrayList<String> data) {

        ArrayList<ScriptObject> output = new ArrayList<>();
        for (String s : data) {
            String[] split = s.split(":");
            assert split.length == 2;
            output.add(new ScriptObject(split[0], split[1]));
        }
        return output;
    }
}

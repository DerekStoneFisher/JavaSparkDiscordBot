package BotPackage.AudioPackage;

import BotPackage.JdaWrapper;
import spark.Request;
import spark.Spark;

/**
 * Created by C17050 on 12/19/2017.
 */
public class Server {
    static JdaWrapper jdaWrapper;

    public static void main(String args[]) throws InterruptedException {
        jdaWrapper = new JdaWrapper();
        startServer(4567);
    }

    public static void startServer(int port){
        Spark.port(port);
        Spark.get("play", (request, response) -> play(request)); // arg = filename (should be a mp3 file)
        Spark.get("play-random", (request, response) -> playRandom(request)); // arg = filename (should be a folder)
    }

    private static String play(Request request){
        String filename = request.queryParams("filename");
        MusicPlayer.play(filename);
        return "";
    }

    private static String playRandom(Request request){
        String filename = request.queryParams("filename");
        MusicPlayer.playRandomTrackFromFolder(filename);
        return "";
    }
}


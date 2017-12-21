package BotPackage;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by C17050 on 12/19/2017.
 */
public class ImageBot {

    public ImageBot() throws FileNotFoundException {

    }

    public File getRandomMeme(){
        File[] memeCollection = Const.memeDirectory.listFiles();
        int maxIndex = memeCollection.length-1; // account for 0 based index so -1
        int randomIndex = ThreadLocalRandom.current().nextInt(0, maxIndex+1); // bound = exclusive, so +1
        return memeCollection[randomIndex];
    }
    public File getBestMemeMatchForStringSlow(String stringToMatchWith, File[] files){
        int comparisons = 0;
        stringToMatchWith = stringToMatchWith.toLowerCase();
        if (files.length > 100000){
            System.out.println("WARNING: ImageBot.getBestMemeMatchForStringSlow is O(n*m), re-write this method if you are going to pass a large input list to it");
        }

        Map<File, Integer> fileToScoreMap = new HashMap<>();

        List<String> stringToMatchWithTokens = tokenizeString(stringToMatchWith);
        for (File file : files){
            List<String> fileNameTokens = tokenizeString(file.getName());
            for (String stringToMatchWithToken : stringToMatchWithTokens) {
                for (String fileNameToken : fileNameTokens) {
                    if (fileNameToken.length() > 0) {
                        comparisons++;
                        int levenshteinDistance = StringUtils.getLevenshteinDistance(stringToMatchWithToken, fileNameToken);
                        if (levenshteinDistance == 0 || (double) levenshteinDistance / (double) fileNameToken.length() <= .1) { // TODO: might need to test this
                            if (fileToScoreMap.containsKey(file)) {
                                fileToScoreMap.put(file, fileToScoreMap.get(file) + 1);
                            } else {
                                fileToScoreMap.put(file, 1);
                            }
                        }
                    }
                }
            }
        }

        Map<File, Integer> sortedFileScoreMap = MiscUtils.sortByComparator(fileToScoreMap, true);
        System.out.println(fileToScoreMap);
        File max = Collections.max(sortedFileScoreMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        return max;

    }

    public List<String> tokenizeString(String string){
        List<String> list = new ArrayList<>();
        for (String split : string.split("([- _.])|((?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z]))")){
            if (!Const.stopWordSet.contains(split.toLowerCase())) {
                list.add(split.toLowerCase());
            }
        }
        return list;
    }
}

import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        ArrayList<Integer> scores = readScores("scores.txt");
        if (scores.size() == 0){
            System.out.println("Scores file has no vaild scores.");
            return;
        }

        System.out.println("Score List: " + scores);
        Double average = calculateAverage(scores);
        
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int score : scores){
            if (score > high){
                high = score;
            }
            if (score < low){
                low = score;
            }
        }

        //Count lines in orgional file to calc the dropped lines
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("scores.txt"))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        writeReport(scores, average, high, low, lineCount, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        String file = filename;
        ArrayList<Integer> scores = new ArrayList<Integer>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        int value = Integer.parseInt(line.trim());
                        scores.add(value);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid value: " + line);
                    }}
                else {
                    System.out.println("Skipping empty line");
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scores;
    }
 
    //Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        double average = 0;

        if (!scores.isEmpty()) {
            for (Integer score: scores){
                average = average + score;
            }
            average = average / scores.size();
        }
        
        return average;

    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low, int lines,
                                   String outputFile) {
        
        String filename = outputFile;

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA = countA + 1; 
            }
            else if (score >= 80) {
                countB = countB + 1;
            }
            else if (score >= 70) {
                countC = countC + 1;
            }
            else if (score >= 60) {
                countD = countD + 1;
            }
            else {
                countF = countF + 1;
            }
            
        }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            System.out.println();
            writer.write("=== Grade Analysis Report ===");
            System.out.println("=== Grade Analysis Report ===");
            writer.newLine();
            writer.write(String.format("Total scores processed: %d%n", scores.size()));   
            System.out.print(String.format("Total scores processed: %d%n", scores.size()));  
            writer.write(String.format("Invalid lines skipped: %d%n", lines - scores.size()));
            System.out.print(String.format("Invalid lines skipped: %d%n", lines - scores.size()));   
            writer.newLine();
            System.out.println();
            writer.write(String.format("Average score: %.2f%n", avg));
            System.out.print(String.format("Average score: %.2f%n", avg));   
            writer.write(String.format("Highest score: %d%n", high));
            System.out.print(String.format("Highest score: %d%n", high));   
            writer.write(String.format("Lowest score: %d%n", low));
            System.out.print(String.format("Lowest score: %d%n", low));   
            writer.newLine();
            System.out.println();
            writer.write("Grade distribution:");
            System.out.println("Grade distribution:");
            writer.newLine();
            writer.write(String.format(" A (90-100): %d%n", countA));
            System.out.print(String.format(" A (90-100): %d%n", countA));      
            writer.write(String.format(" B (80-89): %d%n", countB));  
            System.out.print(String.format(" B (80-89): %d%n", countB)); 
            writer.write(String.format(" C (70-79): %d%n", countC));
            System.out.print(String.format(" C (70-79): %d%n", countC));   
            writer.write(String.format(" D (60-69): %d%n", countD)); 
            System.out.print(String.format(" D (60-69): %d%n", countD));  
            writer.write(String.format(" F (below 60): %d%n", countF)); 
            System.out.print(String.format(" F (below 60): %d%n", countF));    

        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
} 
public class HealthRecord{

    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;
    private static int counter = 1;
    private static double averageHeight = 0;

    // TODO: 1 Think about the initial value for maximum and minimum height
    private static int tallestHeight = MIN_PERMITTED_HEIGHT ;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT ;

    public HealthRecord(int height) {
        setHeight(height);
    }
    public void setHeight(int height) {

        // TODO: (Homework) calculate average height after input validation
        averageHeight = (averageHeight + height)/counter;
        counter = counter + 1;

        // TODO: 2 Check if the input height falls within the permitted range
        if ( height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT )
            this.height = height;
        else
            this.height = DEFAULT_HEIGHT ;

        // TODO: 3 Update the tallest and shortest height
        if ( this.height > tallestHeight )
            tallestHeight = this.height ;
        if ( this.height < shortestHeight )
            shortestHeight = this.height ;

    }

    public int getHeight() {
        return this.height;
    }

    public static int getTallestHeight() {
        return HealthRecord.tallestHeight;
        //return tallestHeight;
    }

    public static int getShortestHeight() {
        return HealthRecord.shortestHeight;
        //return shortestHeight;
    }

    public static double getAverageHeight() {
        return HealthRecord.averageHeight;
        //return averageHeight;
    }

    public static void main(String[] args) {
        HealthRecord student1 = new HealthRecord(120);
        HealthRecord student2 = new HealthRecord(55);
        HealthRecord student3 = new HealthRecord(180);
        student1.displayDetails(); // 120
        student2.displayDetails(); // 55
        student3.displayDetails(); // 180 is not permitted, so it is replaced by default value
        HealthRecord.displayClassDetails(); // tallest = 120, shortest = 55
    }

    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }
    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println("AverageHeight height (cm): " + getAverageHeight());
    }
}

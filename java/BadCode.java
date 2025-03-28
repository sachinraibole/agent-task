public class BadCode {
    public static void main(String[] args) {
      infiniteLoop();
      sqlInject();
      xssVulnerable();
      resourceLeak();
      emptyCatch();
      hardcode();
      passowrd();
      globalVar();
      noEncryption();
      noHttps();
      weakPwdHashing();
      stringConcat();
      insertAtZero();
      noReuse();
      synchList();
      largeLoops();
      boxingExample();
    }
    public void infiniteLoop(){
       int x = 5;
        int y = 10;
        System.out.println("Hello, World!");
        while (x > y) {
            System.out.println("This is an infinite loop!");
        }
    }
    public void sqlInject(){
      String name = "John";
        System.out.println("Hello, " + name + "!");
        // SQL injection vulnerability
        String query = "SELECT * FROM users WHERE name = '" + name + "'";
        // Execute the query
    }
    public void xssVulnerable(){
     // ...
        // XSS vulnerability
        String html = "<script>alert('XSS attack!');</script>";
        System.out.println(html);
    }
    public void memoryLeaks(){
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, "Value " + i);
        }
        // Here we keep adding items to the map without removing them,
        // creating a memory leak because these objects can't be garbage collected.
        System.out.println("Map size: " + map.size());
    }
    // Using a static variable to store instance-specific data
    private static String userName;
    public StaticExample(String name) {
        userName = name; // Overwriting the static variable for every new instance
    }
    public void resourceLeak(){
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        String line = reader.readLine();
        System.out.println(line);
    }
    public void emptyCatch(){
       try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Ignored exception
        }
    }
    public void hardcode(){
        double taxRate = 0.18; // Tax rate hardcoded
        System.out.println("Tax Rate: " + taxRate);
    }
    public void compareStringd(){
        String str1 = "hello";
        String str2 = new String("hello");
        if (str1 == str2) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }
    }
    public static String globalVariable = "Global data";
    public void globalVar() {
        System.out.println(globalVariable);
    }
    private static final String DATABASE_PASSWORD = "mypassword123"; // Hardcoded sensitive information
    public void passowrd() {
        System.out.println("Connecting with password: " + DATABASE_PASSWORD);
    }
    public void noEncryption(){
        String sensitiveInfo = "creditCardNumber123456789"
        System.out.println("Sensitive Info: " + sensitiveInfo); // Exposes plain text data
    }
    public void noHttps(){
        URL url = new URL("http://example.com"); // Using HTTP instead of HTTPS
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();
        System.out.println("Response code: " + conn.getResponseCode());
    }
    public void weakPwdHashing(){
        MessageDigest md = MessageDigest.getInstance("MD5"); // Weak hashing algorithm
        byte[] hashedPassword = md.digest("mypassword".getBytes());
        System.out.println(new String(hashedPassword));
    }
    public void stringConcat(){
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += "data"; // Inefficient as it creates a new String object on every iteration
        }
        System.out.println(result);
    }
    public void insertAtZero(){
       ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(0, i); // Inefficient as it shifts all elements for each insertion
        }
    }
    public void noReuse(){
        for (int i = 0; i < 1000000; i++) {
            new String("Example"); // Creating unnecessary new objects
        }
    }
    public void synchList(){
      List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 1000000; i++) {
            list.add(i); // Synchronization is unnecessary in a single-threaded context
        }
    }
    public void largeLoops(){
      for (int i = 0; i < 1000000; i++) {
            System.out.println("Iteration: " + i); // Printing in every iteration slows down execution
        }
    }
    public void boxingExample(){
        Integer sum = 0; // Using wrapper class instead of primitive type
        for (int i = 0; i < 1000000; i++) {
            sum += i; // Unnecessary boxing and unboxing
        }
    }
}






















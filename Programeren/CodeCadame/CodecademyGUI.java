package CodeCadame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;

public class CodecademyGUI extends Application {

    @Override
    public void start(Stage window) {
        User cu = new User("Name", "Pasword");

        // tools
        // start tools
        Button user = new Button("User");
        Button admin = new Button("Admin");
        Button newStudent = new Button("Add acount");

        // Add student tools
        Text addStudentInfo = new Text("Type name and pasword");
        TextField addStudentName = new TextField("Name");
        addStudentName.setMaxWidth(200);
        TextField addStudentPasword = new TextField("Password");
        addStudentPasword.setMaxWidth(200);
        TextField addStudentEmail = new TextField("Email");
        addStudentEmail.setMaxWidth(200);
        TextField addStudentDate = new TextField("Birth date");
        addStudentDate.setMaxWidth(200);
        TextField addStudentGender = new TextField("Gender");
        addStudentGender.setMaxWidth(200);
        TextField addStudentArea = new TextField("City");
        addStudentArea.setMaxWidth(200);
        TextField addStudentCountry = new TextField("Country");
        addStudentCountry.setMaxWidth(200);
        TextField addStudentZip = new TextField("Zip code");
        addStudentZip.setMaxWidth(200);
        TextField addStudentNumber = new TextField("House number");
        addStudentNumber.setMaxWidth(200);
        Button addStudentAdd = new Button("Add acount");

        // user tools
        // user login tools
        Text userInstruction = new Text("Login with your account name and pasword:");
        TextField userName = new TextField("Name");
        userName.setMaxWidth(100);
        PasswordField userPasword = new PasswordField();
        userPasword.setMaxWidth(100);
        Button userNext = new Button("Login");

        // user after login tools
        Button userCourses = new Button("Courses");
        Button userWebcast = new Button("Webcast");

        // user courses tools
        Text userSignUpInfo = new Text("Type the desired new course name");
        TextField userSignUpName = new TextField();
        userSignUpName.setMaxWidth(200);
        Button userSignUpCourse = new Button("Sign up");
        Text userCoursePercent = new Text("Type the course name to see your progresion");
        TextField userCourseName = new TextField();
        Text userCourseAnswer = new Text(" : ");
        Text userModulPercent = new Text("Type the module name to see your progresion");
        TextField userModuleName = new TextField();
        Text userModuleAnswer = new Text(" : ");

        // user webcast tools
        Text userWatchInfo = new Text("Type the desired webcast name to watch");
        TextField userWatch = new TextField();
        userWatch.setMaxWidth(200);
        Button userWatchButton = new Button("Watch");
        Text userWebcastProgresion = new Text("Type the webcast name to see your progresion");
        TextField userWebcastName = new TextField();
        Text userWebcastAnswer = new Text(" : ");

        // admin tools
        // admin login tools
        Text adminInstruction = new Text("Login with your account name and pasword:");
        TextField adminName = new TextField("Name");
        adminName.setMaxWidth(100);
        PasswordField adminPasword = new PasswordField();
        adminPasword.setMaxWidth(100);
        Button adminNext = new Button("Login");

        // admin after login tools
        Button adminCourses = new Button("Courses");
        Button adminWebcast = new Button("Webcast");

        // admin courses tools
        Text adminCourseTop = new Text("Top 3 courses: " + getInfoStringTop("NaamCursus", "Inschrijving"));
        Text adminCoursePercent = new Text("Type the course name to see the avarage progres and the amount finished");
        TextField adminCourseType = new TextField();
        Text adminCourseAnswer = new Text();
        Button addCourse = new Button("Add course");

        // admin add course tools
        Text courseAddInfo = new Text("Add courses");
        TextField courseAddName = new TextField("Name");
        courseAddName.setMaxWidth(200);
        TextField courseAddSubject = new TextField("Subject");
        courseAddSubject.setMaxWidth(200);
        TextField courseAddIntro = new TextField("Introduction");
        courseAddIntro.setMaxWidth(200);
        TextField courseAddLevel = new TextField("Level");
        courseAddLevel.setMaxWidth(200);
        TextField courseAddModule = new TextField("Module");
        courseAddModule.setMaxWidth(200);
        Button courseAddCourse = new Button("Add course");

        // admin webcasts tools
        Text adminWebcastPercent = new Text(getInfoStringTop("Title", "Kijken"));

        // layout
        // start to choose login type
        HBox loginButton = new HBox();
        loginButton.getChildren().addAll(user, admin, newStudent);
        
        BorderPane loginScreen = new BorderPane();
        loginScreen.setCenter(loginButton);
        
        // create new student
        VBox addStudentButton = new VBox();
        addStudentButton.getChildren().addAll(addStudentInfo, addStudentName, addStudentPasword, addStudentEmail, addStudentDate, addStudentGender, addStudentArea, addStudentCountry, addStudentZip, addStudentNumber, addStudentAdd);

        BorderPane addStudentlayout = new BorderPane();
        addStudentlayout.setCenter(addStudentButton);

        // user layout
        // login for users
        VBox userText = new VBox();
        userText.getChildren().addAll(userInstruction, userName, userPasword, userNext);
                
        BorderPane userLayout = new BorderPane();
        userLayout.setCenter(userText);
        
        // user after login
        HBox userAfterButton = new HBox();
        userAfterButton.getChildren().addAll(userCourses, userWebcast);
        
        BorderPane userAfterLayout = new BorderPane();
        userAfterLayout.setCenter(userAfterButton);

        // user courses 
        HBox userCoursePercentAnswer = new HBox();
        userCoursePercentAnswer.getChildren().addAll(userCourseName, userCourseAnswer);

        HBox userModulePercentAnswer = new HBox();
        userModulePercentAnswer.getChildren().addAll(userModuleName, userModuleAnswer);
                
        VBox userCourseInfoActions = new VBox();
        userCourseInfoActions.getChildren().addAll(userSignUpInfo, userSignUpName, userSignUpCourse, userCoursePercent, userCoursePercentAnswer, userModulPercent, userModulePercentAnswer);
                
        BorderPane userCourseInfoLayout = new BorderPane();
        userCourseInfoLayout.setCenter(userCourseInfoActions);

        // user webcast 
        HBox userWebcastProgresionAnswer = new HBox();
        userWebcastProgresionAnswer.getChildren().addAll(userWebcastName, userWebcastAnswer);
                        
        VBox userWebcastInfoActions = new VBox();
        userWebcastInfoActions.getChildren().addAll(userWatchInfo, userWatch, userWatchButton, userWebcastProgresion, userWebcastProgresionAnswer);
        
        BorderPane userWebcastInfoLayout = new BorderPane();
        userWebcastInfoLayout.setCenter(userWebcastInfoActions);

        // admin layout
        // login for admin
        VBox adminText = new VBox();
        adminText.getChildren().addAll(adminInstruction, adminName, adminPasword, adminNext);
        
        BorderPane adminLayout = new BorderPane();
        adminLayout.setCenter(adminText);

        // admin after login
        HBox adminAfterButton = new HBox();
        adminAfterButton.getChildren().addAll(adminCourses, adminWebcast);

        BorderPane adminAfterLayout = new BorderPane();
        adminAfterLayout.setCenter(adminAfterButton);

        // admin courses 
        HBox adminCoursePercentAnswer = new HBox();
        adminCoursePercentAnswer.getChildren().addAll(adminCourseType, adminCourseAnswer);
        
        VBox adminCourseInfoActions = new VBox();
        adminCourseInfoActions.getChildren().addAll(adminCourseTop, adminCoursePercent, adminCoursePercentAnswer, addCourse);
        
        BorderPane adminCourseInfoLayout = new BorderPane();
        adminCourseInfoLayout.setCenter(adminCourseInfoActions);

        // admin add courses
        VBox adminAddCourses = new VBox();
        adminAddCourses.getChildren().addAll(courseAddInfo, courseAddName, courseAddSubject, courseAddIntro, courseAddLevel, courseAddModule, courseAddCourse);
        
        BorderPane adminAddCourseLayout = new BorderPane();
        adminAddCourseLayout.setCenter(adminAddCourses);

        // admin webcast 
        VBox adminWebcastInfoActions = new VBox();
        adminWebcastInfoActions.getChildren().addAll(adminWebcastPercent);

        BorderPane adminWebcastInfoLayout = new BorderPane();
        adminWebcastInfoLayout.setCenter(adminWebcastInfoActions);

        // create scene
        Scene start = new Scene(loginScreen);
        Scene addStudent = new Scene(addStudentlayout);

        // user scene
        Scene userLogin = new Scene(userLayout);
        Scene userAfter = new Scene(userAfterLayout);
        Scene userCourseScene = new Scene(userCourseInfoLayout);
        Scene userWebcastScene = new Scene(userWebcastInfoLayout);

        // admin scene
        Scene adminLogin = new Scene(adminLayout);
        Scene adminAfter = new Scene(adminAfterLayout);
        Scene adminCourseScene = new Scene(adminCourseInfoLayout);
        Scene adminAddCourse = new Scene(adminAddCourseLayout);
        Scene adminWebcastScene = new Scene(adminWebcastInfoLayout);

        // on action events
        newStudent.setOnAction((event) -> {
            window.setScene(addStudent);
        });

        addStudentAdd.setOnAction((event) -> {
            addStudentMethod(addStudentName.getText(), addStudentEmail.getText(), addStudentDate.getText(), addStudentGender.getText(), addStudentArea.getText(), addStudentCountry.getText(), addStudentZip.getText(), addStudentNumber.getText(), addStudentPasword.getText());
            window.setScene(start);
        });

        // user events
        user.setOnAction((event) -> {
            window.setScene(userLogin);
        });

        userNext.setOnAction((event) -> {
            if (userName.getText().equals(getInfoString("NaamCursist", "Cursist", userName.getText())) && userPasword.getText().equals(getInfoString("Wachtwoord", "Cursist", userPasword.getText()))){
                cu.changeName(userName.getText());
                cu.changePasword(userPasword.getText());
                window.setScene(userAfter);
            }
        });

        userCourses.setOnAction((event) -> {
            window.setScene(userCourseScene);
        });

        userSignUpCourse.setOnAction((event) -> {
            addStartCourseMethod(userSignUpName.getText(), getInfoStringExtend("Email", "Cursist", cu.getName(), "NaamCursist"));
            window.setScene(start);
        });

        userCourseName.setOnAction((event) -> {
            userModuleAnswer.setText(" : "+getInfoIntPrecent("Procent", "Inschrijving", getInfoStringExtend("Email", "Cursist", cu.getName(), "NaamCursist"), "Email", "NaamCursus", userCourseName.getText())+ "%");
        });

        userModuleName.setOnAction((event) -> {
            userCourseAnswer.setText(" : "+getInfoIntPrecent("Procent", "ModulesProcent", getInfoStringExtend("Email", "Cursist", cu.getName(), "NaamCursist"), "Email", "Title", userModuleName.getText())+ "%");
        });

        userWebcast.setOnAction((event) -> {
            window.setScene(userWebcastScene);
        });

        userWatchButton.setOnAction((event) -> {
            addWatchMethod(getInfoStringExtend("Email", "Cursist", cu.getName(), "NaamCursist"), getInfoInt("WebcastID", "Webcast", "Title", userWatch.getText()), userWatch.getText());
            window.setScene(start);
        });

        userWebcastName.setOnAction((event) -> {
            userWebcastAnswer.setText(" : "+getInfoIntPrecent("Procent", "Kijken", getInfoStringExtend("Email", "Cursist", cu.getName(), "NaamCursist"), "Email", "Title", userWebcastName.getText())+ "%");
        });
        
        // admin events
        admin.setOnAction((event) -> {
            window.setScene(adminLogin);
        });

        adminNext.setOnAction((event) -> {
            if (adminName.getText().equals(getInfoString("Naam", "Admin", adminName.getText())) && adminPasword.getText().equals(getInfoString("Wachtwoord", "Admin", adminPasword.getText()))){
                window.setScene(adminAfter);
            }
        });

        adminCourses.setOnAction((event) -> {
            window.setScene(adminCourseScene);
        });

        addCourse.setOnAction((event) -> {
            window.setScene(adminAddCourse);
        });

        adminCourseType.setOnAction((event) -> {
            adminCourseAnswer.setText("Modules progress: "+ getInfoStringModuleCourse(adminCourseType.getText()) + "Course finished: " + getInfoStringCourseFinished(adminCourseType.getText()));
        });

        courseAddCourse.setOnAction((event) -> {
            addCourseMethod(courseAddName.getText(), courseAddSubject.getText(), courseAddIntro.getText(), courseAddLevel.getText(), courseAddModule.getText());
            window.setScene(start);
        });

        adminWebcast.setOnAction((event) -> {
            window.setScene(adminWebcastScene);
        });

        // set stage
        window.setTitle("Mart van Holten 2169198, Xander Holl 2178353" );
        window.setScene(start);
        window.show();
    }

    public static void main(String[] args) {
        
        launch(CodecademyGUI.class);
    }

    // get a disred String
    public static String getInfoString(String info, String location, String input) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT " + info + " FROM " + location + " WHERE " + info + " = ?";
            stmt = con.prepareStatement(SQL);
            stmt.setString(1, input);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String data = rs.getString(info);
                return data;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
        return "NULL";
    }

    // get a disired String where aditional information is needed
    public static String getInfoStringExtend(String info, String location, String input, String where) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT " + info + " FROM " + location + " WHERE " + where + " = ?";
            stmt = con.prepareStatement(SQL);
            stmt.setString(1, input);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String data = rs.getString(info);
                return data;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
        return "NULL";
    }

    // get a desired int
    public static String getInfoInt(String info, String location, String where, String input) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT " + info + " FROM " + location + " WHERE " + where + " = '" + input + "'";
            
            // String SQL = "SELECT " + info + " FROM " + location + " WHERE " + info + " = ?";
            // stmt = con.prepareStatement(SQL);
            // stmt.setString(1, input);
            // rs = stmt.executeQuery();

            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            String request = "NULL";

            while (rs.next()) {
                int result = rs.getInt(info);
                request = String.valueOf(result);

                return request;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
        return "NULL";
    }

    // get a desired precent
    public static String getInfoIntPrecent(String info, String location, String user, String email, String content, String title) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT " + info + " FROM " + location + " WHERE "  + email + " = '" + user + "' AND " + content + "= '" + title + "'";
            
            // String SQL = "SELECT " + info + " FROM " + location + " WHERE " + info + " = ?";
            // stmt = con.prepareStatement(SQL);
            // stmt.setString(1, input);
            // rs = stmt.executeQuery();

            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            String request = "NULL";

            while (rs.next()) {
                int result = rs.getInt(info);
                request = String.valueOf(result);

                return request;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
        return "NULL";
    }

    // get the top 3 of a disered group
    public static String getInfoStringTop(String info, String location) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT TOP 3 COUNT(" + info + "), " + info + " FROM " + location + " GROUP BY " + info + " ORDER BY COUNT(" + info + ") DESC";
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();

            String answer = "";

            while (rs.next()) {
                String title = rs.getString(info);
                answer += title + " | ";
            }
            return answer;
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
        return "NULL";
    }

    // get the avrage of the modules linked to a dissered course
    public static String getInfoStringModuleCourse(String info) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT AVG(ModulesProcent.Procent) AS Avrage, ModulesProcent.Title FROM ModulesProcent INNER JOIN Modules ON Modules.Title=ModulesProcent.Title GROUP BY ModulesProcent.Title, Modules.NaamCursus HAVING Modules.NaamCursus = '"+info+"'";
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();

            String answer = "";

            while (rs.next()) {
                String title = rs.getString("Title");
                String avrage = rs.getString("Avrage");
                answer += avrage + " ," + title + " | ";
            }
            return answer;
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
        return "NULL";
    }

    // get the amount of students that finished the deired course
    public static String getInfoStringCourseFinished(String info) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT COUNT(NaamCursus) AS Count,NaamCursus FROM Inschrijving WHERE Procent = 100 AND NaamCursus = '" + info + "' GROUP BY NaamCursus ORDER BY COUNT(NaamCursus) DESC";
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();

            String answer = "";

            while (rs.next()) {
                String count = rs.getString("Count");
                answer += count;
            }
            return answer;
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
        return "NULL";
    }

    // add a student
    public static void addStudentMethod(String name, String email, String date, String gender, String area, String country, String zip, String number, String pasword) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "INSERT INTO Cursist VALUES ('" + name + "', '" + email + "', '" + date + "',  '"+ gender + "', '" + area + "', '" + country + "', '" + zip + "', '" + number + "', '"+ pasword + "')";
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    // add a wach webcast
    public static void addWatchMethod(String email, String id, String title) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "INSERT INTO Kijken (Email, WebcastID, Titel, Procent) VALUES ('" + email + "', " + id + ", '" + title + "', 0)";
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    // add a start course
    public static void addStartCourseMethod(String name, String email) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "INSERT INTO Inschrijving (NaamCursus, Email, Procent, CertificaatID) VALUES ('" + name + "', '" + email + "', 0, 1)";
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    // add a course
    public static void addCourseMethod(String name, String subject, String intro, String level, String module) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CodeCademy;integratedSecurity=true;";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "INSERT INTO Cursussen VALUES ('" + name + "', '" + subject + "', '" + intro + "',  '"+ level + "'); UPDATE Modules SET NaamCursus = '" + name + "' WHERE Title = '" + module + "';";
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }
}

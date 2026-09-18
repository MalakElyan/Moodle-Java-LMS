# JavaFX Exam Management System

A desktop exam management system built with Java and JavaFX. The application supports separate workflows for administrators, teachers, and students, including question creation, exam preparation, exam solving, result viewing, and exporting exam data.

## Features

### Authentication and Roles

- Admin portal for managing teachers and students.
- Teacher portal for:
  - Adding students.
  - Creating Yes/No, Multiple Choice, and Fill-in-the-Blank questions.
  - Editing and viewing questions.
  - Creating and viewing exams.
  - Viewing student and exam results.
- Student portal for:
  - Viewing available exams.
  - Solving exams.
  - Viewing result details.
  - Editing personal information.
  - Viewing exam-result rankings.
  - Exporting results to a text file.

### Exam Management

- Exams contain an ID, name, question count, and minimum passing average.
- Questions can have marks and type-specific answers.
- Student answers and exam marks are recorded during the session.
- Exams can be exported to text and JSON files.

## Technology Stack

- **Language:** Java 8
- **Desktop UI:** JavaFX and FXML
- **UI Design:** Scene Builder
- **Build Tool:** Apache Ant
- **IDE:** NetBeans
- **Data Management:** Java Collections Framework, including `ArrayList`, `HashMap`, and `HashSet`
- **Persistence:** In-memory data only; no database is currently configured

## Project Structure

```text
src/malak_220226982fx/
├── app/          Application entry point
├── controllers/  JavaFX controllers for the application screens
├── models/      Users, questions, exams, answers, and results
├── services/    Exam system and application operations
└── views/       FXML user interfaces
```

## Requirements

- JDK 8 with JavaFX included.
- NetBeans with JavaFX support.
- Apache Ant, if building from the command line.
- Scene Builder is optional and only needed for editing the FXML screens.

> This project uses the legacy JavaFX/NetBeans project format. Newer JDK versions may require configuring a separate JavaFX SDK and module path.

## How to Run

### NetBeans

1. Clone the repository:

   ```bash
   git clone https://github.com/MalakElyan/Moodle-Java-LMS.git
   ```

2. Open the cloned folder in NetBeans as an existing project.
3. Make sure the project uses JDK 8 and JavaFX.
4. Run the project. The application entry point is:

   ```text
   malak_220226982fx.Malak_220226982fx
   ```

### Apache Ant

From the project root, run:

```bash
ant clean
ant
```

The exact run target may depend on the JavaFX configuration in the local NetBeans installation.

## Demo Login Accounts

The current login accounts are defined in `Exam_system.java`:

| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `admin` |
| Student | `s1` | `123456` |
| Student | `s2` | `123456` |
| Student | `s3` | `123456` |
| Teacher | `JafarAgha` | `112233` |
| Teacher | `MohDalo` | `112233` |
| Teacher | `EtafHadda` | `112233` |
| Teacher | `HashemSaqqa` | `112233` |

## Important Notes

- Data is stored in memory while the application is running. Restarting the application clears students, teachers, questions, exams, and results created during that session.
- Adding a student or teacher through the management screens currently adds the record to the in-memory lists; login validation still uses the predefined accounts above.
- Passwords are stored as plain text in the current educational/demo implementation. This should be replaced with secure password storage before production use.
- Exported files are written to the file path supplied through the export screens.

## Future Improvements

- Connect the system to a relational database for persistent storage.
- Make newly added students and teachers available to the login service.
- Hash passwords and add input validation and user-friendly error messages.
- Improve JavaFX compatibility for modern JDK versions.
- Add automated unit and UI tests.
- Add a clearer build and packaging workflow for distributing the desktop application.

## License

No license has been specified yet. Add a license file before publishing the project for reuse by others.

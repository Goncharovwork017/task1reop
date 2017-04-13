package by.nc.dev3.tools;

import by.nc.dev3.entities.Course;
import by.nc.dev3.entities.Student;
import by.nc.dev3.exceptions.InvalidSerializationException;

import java.io.*;
import java.util.*;

/**
 * Created by ivan on 02.04.2017.
 */
public class FileWorker {
    private final static String filePath = "src//resources//";

    public static String getFilePath() {
        return filePath;
    }

    public <T> boolean serialization(T s, String fileName) {
        boolean flag = false;
        File f = new File(fileName);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(s);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не может быть создан");
        } catch (NotSerializableException e) {
            System.out.println("Класс не поддерживает сериализацию");
        } catch (IOException e) {
            System.out.println("Ошибка");
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия потока");
            }
        }
        return flag;
    }

    public <T> T deserialization(String fileName) throws InvalidSerializationException {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            T st = (T) istream.readObject();
            return st;
        } catch (ClassNotFoundException ce) {
            System.out.println("Класс не существует");
        } catch (FileNotFoundException e) {
            System.out.println("Файл для десериализации не существует");
        } catch (InvalidClassException ioe) {
            System.out.println("Несовпадение версий классов");
        } catch (IOException ioe) {
            throw new InvalidSerializationException("Файл пуст");
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия потока ");
            }
        }
        throw new InvalidSerializationException("Файл пуст");
    }


    public static List<?> readObject(String fileName) {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        List<?> st = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            st = (List<?>) istream.readObject();

        } catch (ClassNotFoundException ce) {
            System.out.println("Класс не существует");
        } catch (
                FileNotFoundException e) {
            System.out.println("Файл для десериализации не существует");
        } catch (InvalidClassException ioe) {
            System.out.println("Несовпадение версий классов");
        } catch (IOException ioe) {
            System.out.println("Файл пуст!");
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.out.println("ошибка закрытия потока ");
            }
        }
        return st;
    }

    public static void writeObject(List<?> list, File file) {
        boolean flag = false;
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(list);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не может быть создан");
        } catch (NotSerializableException e) {
            System.out.println("Класс не поддерживает сериализацию");
        } catch (IOException e) {
            System.out.println("Ошибка");
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия потока");
            }
        }
    }

    public static void writeSheetList(Map<Student, List<Course>> list, File file) {
        boolean flag = false;
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(list);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не может быть создан");
        } catch (NotSerializableException e) {
            System.out.println("Класс не поддерживает сериализацию");
        } catch (IOException e) {
            System.out.println("Ошибка!");
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия потока");
            }
        }
    }

    public static Map<Student, List<Course>> readSheetList(String fileName) {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        Map<Student, List<Course>> st = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            st = (Map<Student, List<Course>>) istream.readObject();

        } catch (ClassNotFoundException ce) {
            System.out.println("Класс не существует");
        } catch (
                FileNotFoundException e) {
            System.out.println("Файл для десериализации не существует");
        } catch (InvalidClassException ioe) {
            System.out.println("Несовпадение версий классов");
        } catch (IOException ioe) {
            System.out.println("Файл пуст!");
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.out.println("ошибка закрытия потока ");
            }
        }
        return st;
    }

    public static double readFile(File file) {
        double str = 0;
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (sc.hasNext())
                str = Double.parseDouble(sc.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден..." + file.getName());
        }
        return str;
    }

    public static void write(double info, File file) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            pw.println(info);
        } catch (IOException e) {
            System.out.println("Ошибка записи. Невозможно создать файл \"" + file.getName() + "\"");
        }
    }

    public static boolean writeByteFile(String price, File file) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true))) {
            bos.write(price.getBytes());
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка записи. Невозможно создать файл \"" + file.getName() + "\"");
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public static String readByteFile(File file) {
        String str = "";
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte arr[] = new byte[bis.available()];
            bis.read(arr);
            str = new String(arr);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден..." + file.getName());
        } catch (IOException e) {
        }
        return str;
    }
}


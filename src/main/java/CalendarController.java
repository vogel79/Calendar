import domain.Calendar;
import domain.Date;
import exception.InvalidDateFormatException;
import service.Addition;
import service.Comparison;
import service.Deletion;
import service.Delta;
import utils.DateInput;
import utils.DateOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalendarController {

    public void readConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вас приветствует календарь!");
        System.out.println("Выберите действие или нажмите '0' для выхода: ");
        System.out.println("1 - найти разницу между датами");
        System.out.println("2 - добавить время к дате");
        System.out.println("3 - вычесть время из даты");
        System.out.println("4 - сравнение дат");
        try {
            String input = reader.readLine();
            while (!"0".equals(input)) {
                switch (input) {
                    case "1":
                        deltaDates(reader);
                        break;
                    case "2":
                        addTime(reader);
                        break;
                    case "3":
                        delTime(reader);
                        break;
                    case "4":
                        comparisonDates(reader);
                        break;
                    default:
                        System.out.println("Неизвестный выбор!");
                }
                System.out.println("Выберите действие или нажмите '0' для выхода: ");
                System.out.println("1 - найти разницу между датами");
                System.out.println("2 - добавить время к дате");
                System.out.println("3 - вычесть время из даты");
                System.out.println("4 - сравнение дат");
                input = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
        }
    }

    private void deltaDates(BufferedReader reader) {
        System.out.println("Найти разницу между датами или '0' для выхода: ");
        System.out.println("1 - в секундах");
        System.out.println("2 - в минутах");
        System.out.println("3 - в часах");
        System.out.println("4 - в годах");
        System.out.println("5 - в месяцах");
        System.out.println("6 - в днях");
        try {
            String input = reader.readLine();
            while (!"0".equals(input)) {
                System.out.println("Выберите формат ввода первой даты: ");
                String format = formatInput(reader);
                System.out.println("Введите дату в формате: " + format);
                Calendar d1 = DateInput.readConsole(format);
                System.out.println("Выберите формат ввода второй даты: ");
                format = formatInput(reader);
                System.out.println("Введите дату в формате: " + format);
                Calendar d2 = DateInput.readConsole(format);
                switch (input) {
                    case "1":
                        long sec = Delta.getNumberOfSeconds(d1, d2);
                        System.out.println("Разница между датами в секундах: " + sec);
                        break;
                    case "2":
                        long minutes = Delta.getNumberOfMinutes(d1, d2);
                        System.out.println("Разница между датами в минутах: " + minutes);
                        break;
                    case "3":
                        long hours = Delta.getNumberOfHours(d1, d2);
                        System.out.println("Разница между датами в чвсах: " + hours);
                        break;
                    case "4":
                        long years = Delta.getNumberOfYears(d1, d2);
                        System.out.println("Разница между датами в годах: " + years);
                        break;
                    case "5":
                        long months = Delta.getNumberOfMonths(d1, d2);
                        System.out.println("Разница между датами в месяцах: " + months);
                        break;
                    case "6":
                        long days = Delta.getNumberOfDays(d1, d2);
                        System.out.println("Разница между датами в днях: " + days);
                        break;
                    default:
                        System.out.println("Неизвестный выбор!");
                }
                System.out.println("Найти разницу между датами или '0' для выхода: ");
                System.out.println("1 - в секундах");
                System.out.println("2 - в минутах");
                System.out.println("3 - в часах");
                System.out.println("4 - в годах");
                System.out.println("5 - в месяцах");
                System.out.println("6 - в днях");
                input = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addTime(BufferedReader reader) {
        System.out.println("Добавить время или '0' для выхода: ");
        System.out.println("1 - секунды");
        System.out.println("2 - минуты");
        System.out.println("3 - часы");
        System.out.println("4 - годы");
        System.out.println("5 - месяцы");
        System.out.println("6 - дни");
        try {
            String input = reader.readLine();
            while (!"0".equals(input)) {
                System.out.println("Выберите формат ввода даты: ");
                String format = formatInput(reader);
                System.out.println("Введите дату в формате: " + format);
                Calendar d1 = DateInput.readConsole(format);
                Date d2 = null;
                Scanner scanner = new Scanner(System.in);
                switch (input) {
                    case "1":
                        System.out.println("Введите количество секунд: ");
                        int seconds = scanner.nextInt();
                        d2 = Addition.addSeconds(seconds, d1.getDate());
                        break;
                    case "2":
                        System.out.println("Введите количество минут: ");
                        int minutes = scanner.nextInt();
                        d2 = Addition.addMinutes(minutes, d1.getDate());
                        break;
                    case "3":
                        System.out.println("Введите количество часов: ");
                        int hours = scanner.nextInt();
                        d2 = Addition.addHours(hours, d1.getDate());
                        break;
                    case "4":
                        System.out.println("Введите количество лет: ");
                        int years = scanner.nextInt();
                        d2 = Addition.addYears(years, d1.getDate());
                        break;
                    case "5":
                        System.out.println("Введите количество месяцев: ");
                        int months = scanner.nextInt();
                        d2 = Addition.addMonths(months, d1.getDate());
                        break;
                    case "6":
                        System.out.println("Введите количество дней: ");
                        int days = scanner.nextInt();
                        d2 = Addition.addDays(days, d1.getDate());
                        break;
                    default:
                        System.out.println("Неизвестный выбор!");
                }
                System.out.println("Выберите формат вывода даты: ");
                String formatOutput = formatOutput(reader);
                System.out.println("Новая дата: ");
                System.out.println(DateOutput.formatDateToString(formatOutput, d2));
                System.out.println("Добавить время или '0' для выхода: ");
                System.out.println("1 - секунды");
                System.out.println("2 - минуты");
                System.out.println("3 - часы");
                System.out.println("4 - годы");
                System.out.println("5 - месяцы");
                System.out.println("6 - дни");
                input = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
        } catch (InputMismatchException e) {
            System.out.println("Неверное число!");
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void delTime(BufferedReader reader) {
        System.out.println("Вычесть время или '0' для выхода: ");
        System.out.println("1 - секунды");
        System.out.println("2 - минуты");
        System.out.println("3 - часы");
        System.out.println("4 - годы");
        System.out.println("5 - месяцы");
        System.out.println("6 - дни");
        try {
            String input = reader.readLine();
            System.out.println("Выберите формат ввода даты: ");
            String format = formatInput(reader);
            System.out.println("Введите дату в формате: " + format);
            Calendar d1 = DateInput.readConsole(format);
            Date d2 = null;
            Scanner scanner = new Scanner(System.in);
            while (!"0".equals(input)) {
                switch (input) {
                    case "1":
                        System.out.println("Введите количество секунд: ");
                        int seconds = scanner.nextInt();
                        d2 = Deletion.delSeconds(seconds, d1.getDate());
                        break;
                    case "2":
                        System.out.println("Введите количество минут: ");
                        int minutes = scanner.nextInt();
                        d2 = Deletion.delMinutes(minutes, d1.getDate());
                        break;
                    case "3":
                        System.out.println("Введите количество часов: ");
                        int hours = scanner.nextInt();
                        d2 = Deletion.delHours(hours, d1.getDate());
                        break;
                    case "4":
                        System.out.println("Введите количество лет: ");
                        int years = scanner.nextInt();
                        d2 = Deletion.delYears(years, d1.getDate());
                        break;
                    case "5":
                        System.out.println("Введите количество месяцев: ");
                        int months = scanner.nextInt();
                        d2 = Deletion.delMonths(months, d1.getDate());
                        break;
                    case "6":
                        System.out.println("Введите количество дней: ");
                        int days = scanner.nextInt();
                        d2 = Deletion.delDays(days, d1.getDate());
                        break;
                    default:
                        System.out.println("Неизвестный выбор!");
                }
                System.out.println("Выберите формат вывода даты: ");
                String formatOutput = formatOutput(reader);
                System.out.println("Новая дата: ");
                System.out.println(DateOutput.formatDateToString(formatOutput, d2));
                System.out.println("Вычесть время или '0' для выхода: ");
                System.out.println("1 - секунды");
                System.out.println("2 - минуты");
                System.out.println("3 - часы");
                System.out.println("4 - годы");
                System.out.println("5 - месяцы");
                System.out.println("6 - дни");
                input = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
        } catch (InputMismatchException e) {
            System.out.println("Неверное число!");
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String formatInput(BufferedReader reader) throws IllegalArgumentException {
        System.out.println("1 - dd/mm/yy");
        System.out.println("2 - m/d/yyyy");
        System.out.println("3 - dd/mm/yyyy hh:mm:ss");
        String result = " ";
        try {
            String input = reader.readLine();
            switch (input) {
                case "1":
                    result = "dd/mm/yy";
                    break;
                case "2":
                    result = "m/d/yyyy";
                    break;
                case "3":
                    result = "dd/mm/yyyy hh:mm:ss";
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный формат!");
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
        }
        return result;
    }

    public static String formatOutput(BufferedReader reader) throws IllegalArgumentException {
        System.out.println("1 - dd/mm/yy");
        System.out.println("2 - m/d/yyyy");
        System.out.println("3 - mmm-d-yy");
        System.out.println("4 - dd-mmm-yyyy hh:mm");
        System.out.println("5 - dd-mmm-yyyy hh:mm:ss");
        String result = " ";
        try {
            String input = reader.readLine();
            switch (input) {
                case "1":
                    result = "dd/mm/yy";
                    break;
                case "2":
                    result = "m/d/yyyy";
                    break;
                case "3":
                    result = "mmm-d-yy";
                    break;
                case "4":
                    result = "dd-mmm-yyyy hh:mm";
                    break;
                case "5":
                    result = "dd-mmm-yyyy hh:mm:ss";
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный формат!");
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
        }
        return result;
    }

    public void comparisonDates(BufferedReader reader) {
        try {
            System.out.println("Введите количество дат, которые желаете сравнить: ");
            Scanner scanner = new Scanner(System.in);
            int count = scanner.nextInt();
            Calendar[] dates = new Calendar[count];
            for (int i = 0; i < count; i++) {
                System.out.println("Выберите формат ввода даты: ");
                String format = formatInput(reader);
                System.out.println("Введите дату в формате: " + format);
                Calendar date = DateInput.readConsole(format);
                dates[i] = date;
            }
            System.out.println("Сравнить даты или '0' для выхода: ");
            System.out.println("1 - перечень исходных дат");
            System.out.println("2 - по возрастанию");
            System.out.println("3 - по убыванию");
            String input = reader.readLine();
            while (!"0".equals(input)) {
                System.out.println("Выберите формат вывода дат: ");
                String formatOutput = formatOutput(reader);
                switch (input) {
                    case "1":
                        System.out.println("Перечень исходных дат:");
                        break;
                    case "2":
                        Comparison.sortBigger(dates);
                        System.out.println("Перечень дат по возрастанию:");
                        break;
                    case "3":
                        Comparison.sortSmaller(dates);
                        System.out.println("Перечень дат по убыванию:");
                        break;
                    default:
                        System.out.println("Неизвестный выбор!");
                }
                for (Calendar date : dates) {
                    if (date != null)
                        System.out.println(DateOutput.formatDateToString(formatOutput, date.getDate()));
                }
                System.out.println("Сравнить даты или '0' для выхода: ");
                System.out.println("1 - перечень исходных дат");
                System.out.println("2 - по возрастанию");
                System.out.println("3 - по убыванию");
                input = reader.readLine();
            }
        } catch (IOException e) {
                System.out.println("Ошибка ввода!");
        } catch (InputMismatchException e) {
            System.out.println("Неверное число!");
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

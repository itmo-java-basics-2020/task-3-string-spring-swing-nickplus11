package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) return new int[]{};
        int tmp = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; --i) {
            int tmp1 = inputArray[i - 1];
            inputArray[i - 1] = inputArray[i];
            inputArray[i] = tmp1;
        }
        inputArray[0] = tmp;
        return inputArray;
        // TODO solve // done
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) return 0;
        int maxPositive1 = 0;
        int maxPositive2 = 0;
        int minNegative1 = 0;
        int minNegative2 = 0;

        for (int i = 0; i < inputArray.length; ++i) {
            if (inputArray[i] > maxPositive2) {
                if (inputArray[i] > maxPositive1) {
                    maxPositive2 = maxPositive1;
                    maxPositive1 = inputArray[i];
                } else maxPositive2 = inputArray[i];
                continue;
            }
            if (inputArray[i] < minNegative2) {
                if (inputArray[i] < minNegative1) {
                    minNegative2 = minNegative1;
                    minNegative1 = inputArray[i];
                } else minNegative2 = inputArray[i];
                continue;
            }
        }
        if (inputArray.length > 2) return Math.max(maxPositive1 * maxPositive2, minNegative1 * minNegative2);
        else if (inputArray.length == 2) return inputArray[0] * inputArray[1];
        else return inputArray[0];
        // TODO solve // done
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null) return 0;
        double count = 0;
        String aim = "ABab";
        for (char c : input.toCharArray()) {
            if (aim.indexOf(c) != -1) ++count;
        }
        double answ = count / input.length() * 100;
        return (int) answ;
        // TODO solve // done
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) return false;
        if (input.length() == 0) return true;
        for (int i = 0; i <= input.length() / 2; ++i) {
            if (input.toCharArray()[i] != input.toCharArray()[input.length() - i - 1]) return false;
        }
        return true;
        // TODO solve // done
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) return "";
        char curChar = input.toCharArray()[0];
        int count = 0;
        String out = "";
        for (int i = 0; i < input.length(); ++i) {
            if (input.toCharArray()[i] == curChar) ++count;
            else {
                out += curChar;
                out += count;
                curChar = input.toCharArray()[i];
                count = 1;
            }
        }
        out += curChar;
        out += count;
        return out;
        // TODO solve // done
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() != two.length() || one.length() == 0) return false;
        for (char c : one.toCharArray()) {
            if (two.indexOf(c) == -1) return false;
            two = two.substring(0, two.indexOf(c)) +
                    two.substring(Math.min(two.indexOf(c)+1, two.length() - 1), two.length());
        }
        return true;
        // TODO solve // done
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) return false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.lastIndexOf(s.toCharArray()[i]) > i) return false;
        }
        return true;
        // TODO solve // done
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) return new int[][]{{}, {}};
        for (int i = 0; i < m.length; ++i) {
            if (m[i] == null) return new int[][]{{}, {}};
            for (int j = i; j < m[i].length; ++j) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
        return m;
        // TODO solve // done
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null) return "";
        StringBuilder sb = new StringBuilder();
        char div;
        div = separator == null ? ' ' : separator;

        for (int i = 0; i < inputStrings.length; ++i) {
            sb.append(inputStrings[i]);
            if (i != inputStrings.length - 1) sb.append(div);
        }
        return sb.toString();
        // TODO solve // done
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) return 0;
        int count = 0;
        for (String s : inputStrings) {
            if (s.indexOf(prefix) == 0) ++count;
        }
        return count;
        // TODO solve // done
    }
}

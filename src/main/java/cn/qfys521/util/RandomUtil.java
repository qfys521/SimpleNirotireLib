package cn.qfys521.util;

import cn.qfys521.string.SuppressWarningsStrings;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class for generating random numbers.
 *
 * <p>This class provides methods to generate random integers, doubles, floats, longs, and booleans within specified
 * ranges.</p>
 */
@SuppressWarnings(SuppressWarningsStrings.UNUSED)
public class RandomUtil {

    /**
     * Generates a random integer.
     *
     * @return A random integer.
     */
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt();
    }

    /**
     * Generates a random integer within the specified bound.
     *
     * @param bound The upper bound (exclusive) for the random integer.
     *
     * @return A random integer within the specified bound.
     */
    public static int randomInt(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    /**
     * Generates a random double between 0.0 and 1.0.
     *
     * @return A random double between 0.0 and 1.0.
     */
    public static double randomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    /**
     * Generates a random double within the specified bound.
     *
     * @param bound The upper bound (exclusive) for the random double.
     *
     * @return A random double within the specified bound.
     */
    public static double randomDouble(double bound) {
        return ThreadLocalRandom.current().nextDouble(bound);
    }

    /**
     * Generates a random float between 0.0f and 1.0f.
     *
     * @return A random float between 0.0f and 1.0f.
     */
    public static float randomFloat() {
        return ThreadLocalRandom.current().nextFloat();
    }

    /**
     * Generates a random float within the specified bound.
     *
     * @param bound The upper bound (exclusive) for the random float.
     *
     * @return A random float within the specified bound.
     */
    public static float randomFloat(float bound) {
        return ThreadLocalRandom.current().nextFloat(bound);
    }

    /**
     * Generates a random long.
     *
     * @return A random long.
     */
    public static long randomLong() {
        return ThreadLocalRandom.current().nextLong();
    }

    /**
     * Generates a random long within the specified bound.
     *
     * @param bound The upper bound (exclusive) for the random long.
     *
     * @return A random long within the specified bound.
     */
    public static long randomLong(long bound) {
        return ThreadLocalRandom.current().nextLong(bound);
    }

    /**
     * Generates a random boolean.
     *
     * @return A random boolean (true or false).
     */
    public static boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
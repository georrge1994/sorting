package com.company;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Main {
    private static final Random r =  new Random();

    @Param({"1", "10", "100", "1000", "10000", "50000","100000"})
    int size;

    private int[] numbers;

    @Setup
    public void setup() {
        numbers = new int[size];
        //******************************************
        switch (size) {
            case 1:
                numbers[0] = 1;
                break;
            case 2:
                numbers[0] = 1;
                numbers[1] = 2;
                break;
            case 3:
                numbers[0] = 2;
                numbers[1] = 1;
                numbers[2] = 3;
                break;
            default:
                numbers[1] = 1;
                numbers[2] = 3;
                for (int step = 4; step <= size; step++)
                    if ((step & 1) == 0)
                        numbers[step-1] = numbers[(step>>1)-1];
                    else{
                        numbers[step-1] = numbers[step>>1];
                        numbers[step>>1] = step;
                    }
                for (int i=0; i<(size>>1); i++)
                    numbers[i] = i+i+2;
                break;
        }

        //*******************************
    }

    @Benchmark
    public void testSort(Blackhole bh) {
        bh.consume(Sort.kthElement(numbers, numbers.length));
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

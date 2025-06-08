package com.dorito.algorithms;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사전식 순서의 숫자 나열 테스트")
class LexicographicalNumbersTest {
    
    private LexicographicalNumbers lexicographicalNumbers;
    
    @BeforeEach
    void setUp() {
        lexicographicalNumbers = new LexicographicalNumbers();
    }

    @Nested
    @DisplayName("기본 기능 테스트")
    class BasicFunctionalityTests {
        
        @ParameterizedTest(name = "n이 {0}일 때의 결과 확인")
        @MethodSource("com.dorito.algorithms.LexicographicalNumbersTest#basicTestCases")
        void testBasicCases(int input, List<Integer> expected) {
            List<Integer> result = lexicographicalNumbers.lexicalOrder(input);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("n이 1일 때 (최소 입력값)")
        void testMinimumInput() {
            List<Integer> result = lexicographicalNumbers.lexicalOrder(1);
            assertEquals(Arrays.asList(1), result);
        }
    }

    @Nested
    @DisplayName("특성 검증 테스트")
    class PropertyValidationTests {
        
        @ParameterizedTest
        @ValueSource(ints = {10, 20, 50, 100})
        @DisplayName("결과 크기 검증")
        void testResultSize(int n) {
            List<Integer> result = lexicographicalNumbers.lexicalOrder(n);
            assertEquals(n, result.size(), "결과 크기는 입력값 n과 같아야 합니다");
        }

        @Test
        @DisplayName("모든 숫자가 한 번씩만 포함되어 있는지 검증")
        void testUniqueNumbers() {
            int n = 50;
            List<Integer> result = lexicographicalNumbers.lexicalOrder(n);
            
            for (int i = 1; i <= n; i++) {
                final int number = i;
                assertEquals(1, result.stream().filter(x -> x.equals(number)).count(),
                        String.format("숫자 %d는 정확히 한 번만 나타나야 합니다", number));
            }
        }

        @ParameterizedTest
        @ValueSource(ints = {13, 20, 50})
        @DisplayName("사전식 순서 검증")
        void testLexicographicalOrdering(int n) {
            List<Integer> result = lexicographicalNumbers.lexicalOrder(n);
            
            for (int i = 0; i < result.size() - 1; i++) {
                String current = result.get(i).toString();
                String next = result.get(i + 1).toString();
                assertTrue(current.compareTo(next) < 0,
                        String.format("%s는 %s보다 사전식 순서상 앞에 위치해야 합니다", current, next));
            }
        }
    }

    @Nested
    @DisplayName("경계값 테스트")
    class BoundaryTests {
        
        @Test
        @DisplayName("n이 10일 때 (한 자리에서 두 자리로 전환)")
        void testTransitionToTwoDigits() {
            List<Integer> result = lexicographicalNumbers.lexicalOrder(10);
            List<Integer> expected = Arrays.asList(1, 10, 2, 3, 4, 5, 6, 7, 8, 9);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("n이 100일 때 (두 자리에서 세 자리로 전환)")
        void testTransitionToThreeDigits() {
            List<Integer> result = lexicographicalNumbers.lexicalOrder(100);
            assertEquals(100, result.size());
            assertEquals(Integer.valueOf(1), result.get(0));
            assertEquals(Integer.valueOf(10), result.get(1));
            assertEquals(Integer.valueOf(100), result.get(2));
            System.out.println(result);
        }
    }

    // 테스트 데이터 제공 메소드
    static Stream<Arguments> basicTestCases() {
        return Stream.of(
            Arguments.of(1, List.of(1)),
            Arguments.of(9, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            Arguments.of(13, Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }
}
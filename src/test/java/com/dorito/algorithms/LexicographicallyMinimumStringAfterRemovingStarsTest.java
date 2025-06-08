package com.dorito.algorithms;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열에서 별표 제거 후 사전순 최소값 찾기 테스트")
class LexicographicallyMinimumStringAfterRemovingStarsTest {

    private LexicographicallyMinimumStringAfterRemovingStars solution;

    @BeforeEach
    void setUp() {
        solution = new LexicographicallyMinimumStringAfterRemovingStars();
    }

    @Nested
    @DisplayName("LeetCode 공식 예제")
    class OfficialExamples {

        @Test
        @DisplayName("예제 1: aaba* → aab")
        void example1() {
            assertThat(solution.clearStars("aaba*"))
                    .isEqualTo("aab");
        }

        @Test
        @DisplayName("예제 2: abc → abc (별표 없음)")
        void example2() {
            assertThat(solution.clearStars("abc"))
                    .isEqualTo("abc");
        }
    }

    @Nested
    @DisplayName("기본 동작 검증")
    class BasicBehaviorTests {

        @ParameterizedTest
        @CsvSource({
                "a*, ''",
                "ab*, b",
                "ba*, b",
                "abc*, bc",
                "cba*, cb"
        })
        @DisplayName("단일 별표 처리 - 가장 작은 문자 제거")
        void singleStarRemovesSmallestCharacter(String input, String expected) {
            assertThat(solution.clearStars(input))
                    .isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "a", "abc", "zyxwvu", "abcdefghijklmnopqrstuvwxyz"})
        @DisplayName("별표가 없으면 원본 문자열 반환")
        void noStarsReturnOriginal(String input) {
            assertThat(solution.clearStars(input))
                    .isEqualTo(input);
        }

        @Test
        @DisplayName("같은 가장 작은 문자가 여러 개일 때 가장 오른쪽 제거")
        void removesRightmostOfSmallestCharacters() {
            // "abab*" → 'a' 중 오른쪽(인덱스 2) 제거 → "abb"
            assertThat(solution.clearStars("abab*"))
                    .isEqualTo("abb");

            // "aaaa*" → 가장 오른쪽 'a' 제거 → "aaa"
            assertThat(solution.clearStars("aaaa*"))
                    .isEqualTo("aaa");
        }
    }

    @Nested
    @DisplayName("복수 별표 처리")
    class MultipleStarsTests {

        @ParameterizedTest
        @CsvSource({
                "ab**, ''",
                "abc**, c",
                "abcd**, cd",
                "dcba**, dc"
        })
        @DisplayName("연속된 별표들 처리")
        void consecutiveStars(String input, String expected) {
            assertThat(solution.clearStars(input))
                    .isEqualTo(expected);
        }

        @ParameterizedTest
        @CsvSource({
                "a*b*, ''",
                "a*b*c*, ''",
                "ab*cd*, cd",
                "abc*def*, cdef"
        })
        @DisplayName("별표와 문자가 교대로 나타나는 패턴")
        void alternatingPattern(String input, String expected) {
            assertThat(solution.clearStars(input))
                    .isEqualTo(expected);
        }

        @Test
        @DisplayName("복잡한 다중 별표 시나리오")
        void complexMultipleStars() {
            assertThat(solution.clearStars("abcdef*g*h*"))
                    .isEqualTo("defgh");

            assertThat(solution.clearStars("ab*cd*ef*"))
                    .isEqualTo("def");
        }
    }

    @Nested
    @DisplayName("알고리즘 우선순위 검증")
    class AlgorithmPriorityTests {

        @Test
        @DisplayName("사전순 우선순위: a < b < c < ... < z")
        void lexicographicalPriority() {
            assertThat(solution.clearStars("zyxwvutsrqponmlkjihgfedcba*"))
                    .isEqualTo("zyxwvutsrqponmlkjihgfedcb"); // 'a' 제거
        }

        @Test
        @DisplayName("동일 문자 중 가장 최근(오른쪽) 우선")
        void rightmostPriorityForSameCharacter() {
            // a가 여러 개일 때 가장 오른쪽 a 제거
            assertThat(solution.clearStars("abacada*"))
                    .isEqualTo("abacad"); // 마지막 'a' 제거

            // b보다 a가 우선, a 중에서는 가장 오른쪽
            assertThat(solution.clearStars("bababa*"))
                    .isEqualTo("babab"); // 마지막 'a' 제거
        }

        @Test
        @DisplayName("문자가 체인으로 연결되어 처리되는지 확인")
        void characterChaining() {
            // 같은 문자가 추가될 때마다 체인의 head가 업데이트되는지 확인
            assertThat(solution.clearStars("abcabc*"))
                    .isEqualTo("abcbc"); // 두 번째 'a' 제거
        }
    }

    @Nested
    @DisplayName("경계값 및 특수 케이스")
    class EdgeCasesTests {

        @ParameterizedTest
        @ValueSource(strings = {"*", "**", "***", "****"})
        @DisplayName("별표만 있는 문자열")
        void onlyStars(String input) {
            assertThat(solution.clearStars(input))
                    .isEmpty();
        }

        @Test
        @DisplayName("모든 문자가 제거되는 경우")
        void allCharactersRemoved() {
            assertThat(solution.clearStars("a*b*c*"))
                    .isEmpty();

            assertThat(solution.clearStars("abc***"))
                    .isEmpty();
        }

        @Test
        @DisplayName("대용량 입력 처리 (성능 테스트)")
        void largeInputPerformance() {
            // 1000개 문자 + 1개 별표
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb.append((char)('a' + (i % 26)));
            }
            sb.append("*");

            String result = solution.clearStars(sb.toString());

            assertThat(result).hasSize(999);
            assertThat(result.charAt(0)).isEqualTo('a'); // 첫 번째 'a' 제거됨
        }

        @Test
        @DisplayName("최대 별표 수 시나리오")
        void maximumStarsScenario() {
            // 문자와 별표가 1:1 비율
            String input = "abcdefghijk***********"; // 11문자 + 11별표

            String result = solution.clearStars(input);

            assertThat(result).isEmpty(); // 모든 문자 제거됨
        }
    }

    @Nested
    @DisplayName("실제 시나리오 시뮬레이션")
    class RealWorldScenarios {

        @Test
        @DisplayName("반복 패턴 문자열")
        void repeatingPatterns() {
            assertThat(solution.clearStars("abcabc*"))
                    .isEqualTo("abcbc");

            assertThat(solution.clearStars("abcabcabc**"))
                    .isEqualTo("abcbcbc");
        }

        @Test
        @DisplayName("알파벳 역순 정렬")
        void reverseAlphabeticalOrder() {
            assertThat(solution.clearStars("zyxwvu*"))
                    .isEqualTo("zyxwv"); // 'u' 제거 (가장 작은 문자)
        }

        @Test
        @DisplayName("동일한 문자로만 구성된 문자열")
        void identicalCharacters() {
            assertThat(solution.clearStars("aaaaa*"))
                    .isEqualTo("aaaa");

            assertThat(solution.clearStars("bbbbb**"))
                    .isEqualTo("bbb");
        }

        @Test
        @DisplayName("별표가 문자열 중간에 산재")
        void starsScatteredInMiddle() {
            assertThat(solution.clearStars("ab*cd*ef*gh"))
                    .isEqualTo("defgh");
        }
    }

    @Nested
    @DisplayName("결과 속성 검증")
    class ResultPropertyValidation {

        @Test
        @DisplayName("결과 문자열에는 별표가 포함되지 않음")
        void resultContainsNoStars() {
            String result = solution.clearStars("a*b*c*d*e*f*");

            assertThat(result).doesNotContain("*");
        }

        @Test
        @DisplayName("별표 제거 과정에서 문자 순서는 보존됨")
        void characterOrderPreserved() {
            // 제거되지 않은 문자들의 상대적 순서는 유지되어야 함
            String result = solution.clearStars("abcdef*");

            assertThat(result).isEqualTo("bcdef"); // 'a'만 제거, 나머지 순서 유지
        }

        @Test
        @DisplayName("입력 길이가 결과 길이보다 크거나 같음")
        void inputLengthGreaterThanOrEqualToResult() {
            String input = "abcdef***";
            String result = solution.clearStars(input);

            assertThat(input.length()).isGreaterThanOrEqualTo(result.length());
        }
    }
}
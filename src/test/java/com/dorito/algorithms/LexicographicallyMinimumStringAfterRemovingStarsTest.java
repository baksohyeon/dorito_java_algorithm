package com.dorito.algorithms;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("문자열에서 별표 제거 후 사전순 최소값 찾기 테스트")
class LexicographicallyMinimumStringAfterRemovingStarsTest {

    private LexicographicallyMinimumStringAfterRemovingStars solution;

    @BeforeEach
    void setUp() {
        solution = new LexicographicallyMinimumStringAfterRemovingStars();
    }

    @Nested
    @DisplayName("basic test")
    class BasicTests {

        @Test
        @DisplayName("별표가 없는 문자열은 그대로 반환되어야 함")
        void shouldReturnSameStringWhenNoStars() {
            // Given
            String input = "abc";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("abc");
        }

        @Test
        @DisplayName("단일 문자는 그대로 반환되어야 함")
        void shouldHandleSingleCharacter() {
            // Given
            String input = "a";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("a");
        }
    }

    @Nested
    @DisplayName("예제 케이스 테스트")
    class ExampleTests {

        @Test
        @DisplayName("예제 1: aaba* -> aab")
        void shouldHandleExample1() {
            // Given
            String input = "aaba*";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("aab");
        }

        @Test
        @DisplayName("예제 2: abc -> abc (별표 없음)")
        void shouldHandleExample2() {
            // Given
            String input = "abc";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("abc");
        }
    }

    @Nested
    @DisplayName("별표 처리 테스트")
    class StarRemovalTests {

        @Test
        @DisplayName("하나의 별표는 왼쪽에서 사전순으로 가장 작은 문자를 제거해야 함")
        void shouldRemoveSmallestCharacterToLeft() {
            // Given
            String input = "bac*";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("bc");
        }

        @Test
        @DisplayName("여러 개의 별표는 순차적으로 처리되어야 함")
        void shouldHandleMultipleStars() {
            // Given
            String input = "dcba**";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("dc");
        }

        @Test
        @DisplayName("연속된 같은 문자에서 별표 처리 - 가장 오른쪽 문자 제거")
        void shouldRemoveRightmostOfSameCharacters() {
            // Given
            String input = "aaa*";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("aa");
        }

        @Test
        @DisplayName("별표 앞에 다양한 문자가 있을 때 가장 작은 문자 제거")
        void shouldRemoveSmallestAmongVariousCharacters() {
            // Given
            String input = "zyxabc*";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("zyxbc");
        }
    }

    @Nested
    @DisplayName("복잡한 케이스 테스트")
    class ComplexTests {

        @Test
        @DisplayName("별표와 문자가 번갈아 나타나는 경우")
        void shouldHandleAlternatingStarsAndChars() {
            // Given
            String input = "a*b*c*";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("");
        }

        @Test
        @DisplayName("긴 문자열에서 여러 별표 처리")
        void shouldHandleMultipleStarsInLongString() {
            // Given
            String input = "abcdef*g*h*";

            // When
            String result = solution.clearStars(input);

            // Then
            // 첫 번째 *: 'a' 제거, 두 번째 *: 'b' 제거, 세 번째 *: 'c' 제거
            assertThat(result).isEqualTo("defgh");
        }

        @Test
        @DisplayName("연속된 별표들 처리")
        void shouldHandleConsecutiveStars() {
            // Given
            String input = "abcd***";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("d");
        }

        @Test
        @DisplayName("복잡한 패턴 - 문자열 중간과 끝에 별표")
        void shouldHandleComplexPattern() {
            // Given
            String input = "ab*cd*ef*";

            // When
            String result = solution.clearStars(input);

            // Then
            // 첫 번째 *: 'a' 제거, 두 번째 *: 'b' 제거, 세 번째 *: 'c' 제거
            assertThat(result).isEqualTo("def");
        }

        @Test
        @DisplayName("사전순으로 정렬된 문자열에서 별표 처리")
        void shouldHandleSortedString() {
            // Given
            String input = "abcdefg*";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("bcdefg");
        }

        @Test
        @DisplayName("역순으로 정렬된 문자열에서 별표 처리")
        void shouldHandleReverseSortedString() {
            // Given
            String input = "gfedcba*";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("gfedcb");
        }
    }

    @Nested
    @DisplayName("엣지 케이스 테스트")
    class EdgeCaseTests {

        @Test
        @DisplayName("별표만 있는 문자열 (제거할 문자가 없음)")
        void shouldHandleOnlyStars() {
            // Given
            String input = "***";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("");
        }

        @Test
        @DisplayName("모든 문자가 제거되는 경우")
        void shouldHandleAllCharactersRemoved() {
            // Given
            String input = "a*b*c*";

            // When
            String result = solution.clearStars(input);

            // Then
            assertThat(result).isEqualTo("");
        }

        @Test
        @DisplayName("최대 길이 문자열 시뮬레이션")
        void shouldHandleLargeInput() {
            // Given
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb.append((char)('a' + (i % 26)));
            }
            sb.append("*");
            String input = sb.toString();

            // When
            String result = solution.clearStars(input);

            // Then
            // 첫 번째 'a'가 제거되고 나머지는 유지되어야 함
            assertThat(result).hasSize(999);
            assertThat(result.charAt(0)).isEqualTo('a');
        }

        @Test
        @DisplayName("동일한 문자들과 별표의 조합")
        void shouldHandleIdenticalCharactersWithStars() {
            // Given
            String input = "aaaaa*a*a*";

            // When
            String result = solution.clearStars(input);

            // Then
            // 5개의 'a' 중 1개 제거, 새로운 'a' 추가 후 제거, 또 새로운 'a' 추가 후 제거
            // 최종적으로 처음 4개의 'a'만 남음
            assertThat(result).isEqualTo("aaaa");
        }
    }

    @Nested
    @DisplayName("사전순 최소값 검증 테스트")
    class LexicographicalMinimumTests {

        @Test
        @DisplayName("여러 선택지 중 사전순으로 가장 작은 결과 확인")
        void shouldReturnLexicographicallySmallestResult() {
            // Given
            String input = "bacb*";

            // When
            String result = solution.clearStars(input);

            // Then
            // 'a'를 제거하면 "bcb", 'b'를 제거하면 "acb" 또는 "bac"
            // 사전순으로 가장 작은 것은 "acb"가 아니라 "bcb"
            assertThat(result).isEqualTo("bcb");
        }

        @Test
        @DisplayName("복수의 가장 작은 문자 중 아무거나 제거 가능")
        void shouldRemoveAnyOfSmallestCharacters() {
            // Given
            String input = "abab*";

            // When
            String result = solution.clearStars(input);

            // Then
            // 'a' 중 아무거나 제거 가능하므로 "bab" 또는 "abb" 가능
            // 하지만 알고리즘상 가장 오른쪽 'a'가 제거됨
            assertThat(result).isEqualTo("abb");
        }
    }
}
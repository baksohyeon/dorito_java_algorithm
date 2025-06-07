package com.dorito.algorithms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Two Sum Algorithm Tests")
class TwoSumTest {
    
    private TwoSum twoSum;
    
    @BeforeEach
    @SuppressWarnings("unused")
    void setUp() {
        twoSum = new TwoSum();
    }
    
    @Nested
    @DisplayName("Optimized HashMap Solution")
    @SuppressWarnings("unused")
    class OptimizedSolutionTests {
        
        @Test
        @DisplayName("Should find two numbers that add up to target")
        void shouldFindTwoNumbersThatAddUpToTarget() {
            // Given
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            
            // When
            int[] result = twoSum.twoSum(nums, target);
            
            // Then
            assertThat(result).hasSize(2);
            assertThat(nums[result[0]] + nums[result[1]]).isEqualTo(target);
            assertThat(result).containsExactly(0, 1);
        }
        
        @Test
        @DisplayName("Should handle negative numbers")
        void shouldHandleNegativeNumbers() {
            // Given
            int[] nums = {-3, 4, 3, 90};
            int target = 0;
            
            // When
            int[] result = twoSum.twoSum(nums, target);
            
            // Then
            assertThat(result).hasSize(2);
            assertThat(nums[result[0]] + nums[result[1]]).isEqualTo(target);
        }
        
        @Test
        @DisplayName("Should work with duplicate values")
        void shouldWorkWithDuplicateValues() {
            // Given
            int[] nums = {3, 3};
            int target = 6;
            
            // When
            int[] result = twoSum.twoSum(nums, target);
            
            // Then
            assertThat(result).hasSize(2);
            assertThat(nums[result[0]] + nums[result[1]]).isEqualTo(target);
            assertThat(result).containsExactly(0, 1);
        }
        
        @Test
        @DisplayName("Should throw exception when no solution exists")
        void shouldThrowExceptionWhenNoSolutionExists() {
            // Given
            int[] nums = {1, 2, 3};
            int target = 7;
            
            // When & Then
            assertThatThrownBy(() -> twoSum.twoSum(nums, target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No two sum solution");
        }
    }
    
    @Nested
    @DisplayName("Brute Force Solution")
    @SuppressWarnings("unused")
    class BruteForceSolutionTests {
        
        @Test
        @DisplayName("Should find two numbers that add up to target (brute force)")
        void shouldFindTwoNumbersThatAddUpToTargetBruteForce() {
            // Given
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            
            // When
            int[] result = twoSum.twoSumBruteForce(nums, target);
            
            // Then
            assertThat(result).hasSize(2);
            assertThat(nums[result[0]] + nums[result[1]]).isEqualTo(target);
            assertThat(result).containsExactly(0, 1);
        }
        
        @Test
        @DisplayName("Should throw exception when no solution exists (brute force)")
        void shouldThrowExceptionWhenNoSolutionExistsBruteForce() {
            // Given
            int[] nums = {1, 2, 3};
            int target = 7;
            
            // When & Then
            assertThatThrownBy(() -> twoSum.twoSumBruteForce(nums, target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No two sum solution");
        }
    }
    
    @ParameterizedTest
    @MethodSource("provideTwoSumTestCases")
    @DisplayName("Should solve various two sum cases")
    void shouldSolveVariousTwoSumCases(int[] nums, int target, int[] expected) {
        // When
        int[] result = twoSum.twoSum(nums, target);
        
        // Then
        assertThat(result).hasSize(2);
        assertThat(nums[result[0]] + nums[result[1]]).isEqualTo(target);
        // Note: We don't check exact indices as there might be multiple valid solutions
    }
}


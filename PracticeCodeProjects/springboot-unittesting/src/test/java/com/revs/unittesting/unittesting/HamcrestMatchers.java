package com.revs.unittesting.unittesting;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matcher.*;
//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchers {

    @Test
    public void testListClass() {
        List<Integer> nums = Arrays.asList(1,3,7,4);

        assertThat(nums, hasSize(2));
        assertThat(nums, hasItems(5));
        assertThat(nums, everyItem(greaterThan(0)));
        assertThat(nums, everyItem(lessThan(10)));

        assertThat("", is(emptyString()));

    }


}

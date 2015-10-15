/**
 * Created by pedro on 10/09/14.
 */

import groovy.transform.TailRecursive
@TailRecursive
int factorial(int number, int aggregator = 1) {
    if (number == 1)
        return aggregator
    return factorial(number - 1, number * aggregator)
}

println factorial(10, 1)
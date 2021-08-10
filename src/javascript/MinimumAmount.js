/**
 * MINIMUM AMOUNT
 *
 * Alex has a list of items to purchase at a market. The owner offers to discount each item after the first one by the
 * lowest marked price among the prior items. No item's price can be discounted below 0, and the list of items may not
 * be recorded. Calculate the payable amount.
 *
 * EXAMPLE
 *
 * prices=[2,5,1,4]
 *
 * Alex pays 2 for the first item since there no previous items to compare to.
 * The second item costs 5-2=3
 * The third item is free: max(1 - min(2,5), 0) = max(-1, 0) = 0
 * The fourth item costs 4-1=3
 *
 * The total cost to purchase all items is 2 + 3 + 0 + 3 = 8
 *
 * @param prices
 */
function calculateAmount(prices) {
    let min = prices[0]
    let total = min
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] < min) {
            min = price[i]
        } else {
            total = total + price[i] - min;
        }
    }
    return total;
}
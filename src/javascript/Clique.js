function ret(n, k) {
    const g1 = n % k;
    const g2 = k - g1;
    const sz1 = Math.floor(n / k + 1);
    const sz2 = Math.floor(n / k);
    return g1 * sz1 * g2 * sz2 + g1 * (g1 - 1) * sz1 * sz1 / 2 + g2 * (g2 - 1) * sz2 * sz2 / 2;
}

function solve(numNodes, numEdges) {
    let k, low = 1;
    let high = numNodes + 1;

    while (low + 1 < high) {
        let mid = Math.floor(low + (high - low) / 2);
        // console.log("mid: ", mid)
        k = ret(numNodes, mid);
        // console.log("k: ", k)
        if (k < numEdges) {
            low = mid;
        } else {
            high = mid;
        }
    }
    return high;
}

console.log(solve(3, 2))
console.log(solve(4, 6))
console.log(solve(5, 7))
/**
 * STRONGLY CONNECTED GROUPS
 *
 * A group of software engineers want to develop an algorithm for finding strongly connected groups among members of a
 * social networking site. A group of people are considered to be strongly connected if each person knows every other
 * person within the group.
 *
 * The engineers decide to start by tackling a smaller task first. If a network contains n people and there are m pairs
 * of relationships connecting them, what is the minimum size of the largest strongly connected group in the network.
 *
 * HINT: think of the people as nodes in a graph, and their relationships are edges that connect them.
 *
 * EXAMPLE
 *
 * numNodes = 2; numEdges = 1; -> 2
 * numNodes = 3; numEdges = 2; -> 2
 * numNodes = 4; numEdges = 6; -> 4
 * numNodes = 5; numEdges = 7; -> 3
 *
 * @param numNodes
 * @param numEdges
 */
function minFriends(numNodes, numEdges) {
    let k, l = 1
    let h = numNodes + 1
    while ( l + 1 < h) {
        let mid = Math.floor(l + (h - l) / 2)
        k = cal(numNodes, mid)
        if (k < numEdges) {
            l = mid
        } else {
            h = mid
        }
    }
    return h
}

function cal(n, k) {
    const g1 = n % k
    const g2 = k - g1
    const sz1 = Math.floor(n / k + 1)
    const sz2 = Math.floor(n / k)
    return g1 * sz1 * g2 * sz2 + g1 * (g1 - 1) * sz1 * sz1 / 2 + g2 * (g2 - 1) * sz2 * sz2 / 2
}

console.log(minFriends(3, 2))
console.log(minFriends(4, 6))
console.log(minFriends(5, 7))

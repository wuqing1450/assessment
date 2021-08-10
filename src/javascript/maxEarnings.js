function taxiDriver(pickup, drop, tip) {
    let v = [];
    let total = 0;
    let maxProfits = [];

    for (let i = 0; i < tip.length; i++) {
        let x = pickup[i]
        let y = drop[i]
        let e = drop[i] - pickup[i] + tip[i]
        let m = {"from": x, "to": y, "earn": e};
        v.push(m)
    }

    for (let i = 0; i < tip.length; i++) {
        maxProfits[i] = 0;
        for (let j = 0; j < i; j++) {
            if(v[j]["to"] <= v[i]["from"] && maxProfits[i] < maxProfits[j]) {
                maxProfits[i] = maxProfits[j]
            }
        }
        maxProfits[i] = maxProfits[i] + v[i]["earn"];
    }

    for (let k of maxProfits) {
        if (k > total) {
            total = k;
        }
    }

    return total;
}

let pickup = [0, 2, 9, 10, 11, 12]
let drop = [5, 9, 11, 11, 14, 17]
let tip = [1, 2, 3, 2, 2, 1]
console.log(taxiDriver(pickup, drop, tip))

pickup = [1, 4]
drop = [5, 6]
tip = [2, 5]
console.log(taxiDriver(pickup, drop, tip))

pickup = [0, 4, 5]
drop = [3, 5, 7]
tip = [1, 2, 2]
console.log(taxiDriver(pickup, drop, tip))
# 2 3 5 8 -> 21%8 -> 5
# 9110 7553 8356 5441 -> ?%5441 -> ?
a=$1
b=$2
n=$3
m=$4
echo "input: $a $b $n $m"

for ((i=0; i<n;  i++))
do
  fn=$((a+b))
  a=$b
  b=$fn
done

echo "output: $((a%m))"
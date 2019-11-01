## deepCopy

your header:
```
public static Map<String, List<Integer>> deepCopy(Map<String, List<Integer> map){
    // wirte your code
}
```

Test your skill iterating through map structure
```
pseudo code:

find a way to access all possible keys:
  keys <- map.keySet()

Set is iterable, so:
  newMap <- new Map<String, List<Integer>()

  for each (key in keys) {
    list <- map.get(key)
    newList <- new List<String>()

    for each (word in list) {
      newList.add(word)
    }

    newMap.put(key, newList)
  }
```

## commonFirstLetters
```
public static List<String> commonFirstLetters(List<String>){
    // wirte your code
}
```

Possible Approach:
 1. It would be great if we could store all these into a special `Set` that allows up to two identical String! We'll just ask the Set **"which are the Strings that duplicated?"**

 2. Since we do not have that, we can look at its relative, `Map`.

Map approch:
  1. everythime we go through a word in the list, we consider only the first letter.
  `char c = word.charAt(0)` or `String s = "" + word.charAt(0)`
  2. we map each first letter seen to a value of **number of times we seen it**, or **count**.
  3. we loop through map's `keySet` to check which are the first letters apperaed more than once, then store those letters into our result list.

## commonHobbies
Nothing else to say other than reverse the mapping.

**Before:**

map(x) ---> a and b and c

**After:**

map(a) ---> x

map(b) ---> x

## takingAlongside
your given structure: `Map<String, Set<String>>`

and you want to output a list of unique, ordered classes taken.

You use TreeSet to store answers to ensure unique, ordered, and iterate through the given keySet of map to include all courses taken by an student taking the desired course.

```
courseAskedFor <- "???"
answerSet <- new TreeSet<String>()

for each (key in keySet)
  set <- map.get(key)
  if (set.contains(courseAskedFor))
    answerSet.addAll(set)

return answerSet
```

# ArrayIntList
## maxCount
Since the array is already sorted, we'll just loop through the array to find the max length, and update it by max+=1 if elementData[i] == elementData[i-1]!

```
if(this.size <= 1) {
  return this.size;
}
max <- 1
count <- 1
for (i = 1; i < this.size; i++)
  if elementData[i] == elementData[i-1]
    count++
  else
    count = 1

  if count > max
    max = count

return max
```

## removeMax

Similar to last time, we'll have to find max first:

Approach:
1. find max and record its index
2. shift every element after index (index+1, index+2 ...) to index's relative position (to index, index+1 ...)
3. fix the this.size

```
if (size == 0)
  throw IllegalStateException
if (size == 1)
  size = 0

max <- elementData[0]
maxIndex <- 0
for(int i=1; i<size; i++)
  if(elementData[i]>max)  //only find first max
    max <- elementData[i]
    maxIndex <- index

for(int i=maxIndex; i<size-1; i++)
  elementData[i] = elementData[i+1]
```

## removeOddPositions
Now you seen this, but you need something to fix your elementData since it's not dynamic. **We need two indices**! One tracks where we are in the array, another tracks where have we filled the array.

```
amountRemoved <- 0
j <- 0

for (int i=0; i<size; i++)
  if(i%2==0)
    elementData[j] = elementData[i]
    j++
  else
    amountRemoved++

this.size -= amountRemoved
```

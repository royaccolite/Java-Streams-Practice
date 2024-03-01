import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractice2 {
    public static void main(String[] args) {
        List<String> strings =(Arrays.asList("amitabha", "sakshi", "lahiri", "asish", "amar","nandhitha","sridhar"));
        //3
        List<String> upperCaseString= strings.stream().map(
                s -> s.toUpperCase(Locale.ROOT)
        ).collect(Collectors.toList());
        System.out.println(upperCaseString);
        //odd numbers till 1 to 100
        List<Integer> res= Stream.iterate(1,i->i+1).limit(100).filter(num ->{
            if(num<2) return  false;
            for(int i=2;i*i<=num;i++){
                if(num%i==0) return false;
            }
            return true;
        }).toList();
        System.out.println(res);

        List<Integer> nums=Stream.iterate(1,i->i+1).limit(50).filter(num ->{
            if(num%3 ==0) return true;
            return false;
        }).toList();
        System.out.println(nums);
        //4
        List<Integer> evenNums=nums.stream().filter( num -> {
            if(num %2 ==0) return  true;
            else return false;
        }).collect(Collectors.toList());
        System.out.println(evenNums);
        //5
        List<String> specificString=strings.stream().filter(s -> {
            if(s.charAt(0)=='a') return true;
            else return false;
        }).toList();
        System.out.println(specificString);
        //6
        List<Integer> squares=nums.stream().map(a-> a*a).collect(Collectors.toList());
        System.out.println(squares);

        //7

        String grads=strings.stream().reduce("",(a,b)->a+b+" ");
        System.out.println(grads);
        // 8
        double avgDouble=nums.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        System.out.println(avgDouble);
        
        //9
        boolean allPos=nums.stream().allMatch(a->{
            if(a%2==0) return true;
            return false;
        });
        System.out.println(allPos);

        //10

        List<Integer> oneToTen=Stream.iterate(1,i->i+1).limit(10).toList();
        System.out.println(oneToTen);

        //11
        //12
        //13
        var countOccurences=nums.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(countOccurences);
        //14
        List<Integer> skipFirstThree= nums.stream().sorted().skip(3).collect(Collectors.toList());
        System.out.println(skipFirstThree);

        //15

        List<Integer> limitToN=nums.stream().limit(5).skip(3).toList();
        System.out.println(limitToN);
        //16
        List<Integer> distinct =nums.stream().distinct().toList();
        System.out.println(distinct);
        List<Integer> reverse=nums.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(reverse);

        //18
        List<String> intToString=nums.stream().map(n->Integer.toString(n)).toList();
        System.out.println(intToString);
        //19
        List<String> alphabeticalOrder=strings.stream().sorted((a,b)->
            a.compareTo(b)
        ).toList();
        System.out.println(alphabeticalOrder);
        //20
        String singleString=strings.stream().reduce("",(a,b)->a+b);
        System.out.println(singleString);

        //21
        var removeDuplicates=nums.stream().distinct().toList();
        System.out.println(removeDuplicates);
        //23
        int maxLenStr=strings.stream().map(s->s.length()).max(Integer::compare).orElse(-1);
        System.out.println(maxLenStr);
        //26
        List<List<String>> lsls = Arrays.asList(
                Arrays.asList("apple", "orange"),
                Arrays.asList("banana", "grape"),
                Arrays.asList("kiwi", "melon")
        );
        List<String> flatmap=lsls.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatmap);

        //27

        String shortestName=strings.stream().min((a,b)->Integer.compare(a.length(),b.length())).orElse(null);

        System.out.println(shortestName);

        //28
        List<Integer> greaterThanN=nums.stream().filter(n-> {
            return n>14;
        }).collect(Collectors.toList());
        System.out.println(greaterThanN);


        //29
         Map<Boolean,List<Integer>> evenOddPartition=nums.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(evenOddPartition );

        //30

        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("X", "Y", "Z");

        List<String> combinedList= IntStream.range(0,Math.min(list1.size(), list2.size()))
                .mapToObj(i-> Arrays.asList(list1.get(i),list2.get(i)))
                .flatMap(List:: stream)
                .toList();
        System.out.println(combinedList);

        //31
        int product=nums.stream().reduce(1,(a,b)->a*b);
        System.out.println(product);

        //32

        List<String> minLenSorted=strings.stream().sorted((a,b)->Integer.compare(a.length(),b.length())).collect(Collectors.toList());

        System.out.println(minLenSorted);
        System.out.println(strings.stream().sorted().collect(Collectors.toList()));

        //33
//        strings.add(2,null);
        System.out.println(strings);
        strings=strings.stream().filter(s-> {
            return s != null;
        }).collect(Collectors.toList());
        System.out.println(strings);

        //35
        Set<Integer> set=new HashSet<>();
//        nums=new ArrayList<>(Arrays.asList(3,3));
        boolean allUnique=nums.stream()
                .allMatch(a->set.add(a));
        System.out.println(allUnique);

        //37

        String longestString = strings.stream()
                .max((a,b) -> Integer.compare(a.length(),b.length())).toString();
        System.out.println(longestString);

        //38

        int sumOfSquares=nums.stream().map(n-> n*n).reduce(0,(a,b)->a+b);
        System.out.println(sumOfSquares);

        //40
        boolean substringmathc=strings.stream().anyMatch(s->s.contains("tab"));

        System.out.println(substringmathc);

        //42

        Set<Integer> set1=nums.stream().collect(Collectors.toSet());
        System.out.println(set1);

        //43
        List<Book> books = new ArrayList<>();

        books.add(new Book(1, 20, "Book1"));
        books.add(new Book(2, 25, "Book2"));
        books.add(new Book(3, 30, "Book3"));
        books.add(new Book(4, 105, "Book4"));
        books.add(new Book(5, 50, "Book5"));
        books.add(new Book(6, 65, "Book6"));
        books.add(new Book(7, 90, "Book7"));
        books.add(new Book(8, 55, "Book8"));
        books.add(new Book(9, 80, "Book9"));
        books.add(new Book(10, 65, "Book10"));


        Book highestPrice=books.stream()
                .max((a,b)->Integer.compare(a.price,b.price)).orElse(null);
        System.out.println(highestPrice);


        List<Book> customSortOfBook = books.stream().sorted(Comparator.comparing(Book:: getPrice).reversed()
                .thenComparing(Book::getId)
                .thenComparing(Book::getName)).collect(Collectors.toList());
        System.out.println(customSortOfBook);

        //44
        double avgLength=strings.stream().mapToDouble(s->s.length()).average().getAsDouble();
        System.out.println(avgLength);

        //46

        Map<Integer, Long> countOccurence=nums.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(countOccurence);

        //48
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);
        Set<Integer> set2=list3.stream().collect(Collectors.toSet());
        List<Integer> commonElements=list4.stream().filter(set2::contains).collect(Collectors.toList());
        System.out.println(commonElements);


        //given a string find then number of occurences of each word

        String input = "my name is avleen and my last name is kaur";

        Map<String, Long> wordCounts = Arrays.stream(input.split("\\s+"))  // Split the input string into words
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));  // Count occurrences of each word

        // Print the word counts
        wordCounts.forEach((word, count) -> System.out.println(word + ": " + count));

        //given a matrix find max element of each row
        List<List<Integer>> matrix=new ArrayList<>(Arrays.asList(
                Arrays.asList(3,5,12,4,7),
                Arrays.asList(6,4,3,8),
                Arrays.asList(52,98,13,98)
        ));
        List<Integer> maxInRow=matrix.stream().
                map(row->row.stream().max((a,b)->Integer.compare(a,b)).orElse(-1)).collect(Collectors.toList());
        System.out.println(maxInRow);


    }
    static public class Book{
        int id;
        int price;
        String  name;
        Book(int id,int price,String name){
            this.id=id;
            this.price=price;
            this.name=name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", price=" + price +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

class Test {
  public static void main(java.lang.String[] args) {
    int[] solutionArray = new int[]{ 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };
    Class_.Test.shuffleArray(int[])
    for (int i = 0; i < solutionArray.length; i++) {
      java.io.PrintStream.print(java.lang.String)
    }
    java.io.PrintStream.println()
  }

  // Implementing Fisher???Yates shuffle
  static void shuffleArray(int[] ar) {
    // If running on Java 6 or older, use `new Random()` on RHS here
    java.util.Random rnd = java.util.concurrent.ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--) {
      int index = java.util.Random.nextInt(int);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }

  protected static java.util.List<java.lang.Integer> range(int n) {
    return Class_.Test.toList(java.lang.Iterable,java.util.List);
  }

  protected static <T> java.util.List<T> toList(java.lang.Iterable<T> iterable) {
    return Class_.Test.toList(java.lang.Iterable,java.util.List);
  }

  protected static <T> java.util.List<T> toList(java.lang.Iterable<T> iterable, java.util.List<T> destination) {
    Class_.Test.addAll(java.util.Collection,java.util.Iterator)
    return destination;
  }

  protected static <T> void addAll(java.util.Collection<T> collection, java.util.Iterator<T> iterator) {
    while (java.util.Iterator.hasNext()) {
      java.util.Collection.add(java.lang.Object)
    } 
  }

  private static class Range implements java.lang.Iterable<java.lang.Integer> {
    private int start;

    private int stop;

    private int step;

    private Range(int n) {
      Class_.Test$Range.Class_.Test$Range(int,int,int)
    }

    private Range(int start, int stop) {
      Class_.Test$Range.Class_.Test$Range(int,int,int)
    }

    private Range(int start, int stop, int step) {
      this.start = start;
      this.stop = stop;
      this.step = step;
    }

    @java.lang.Override
    public java.util.Iterator<java.lang.Integer> iterator() {
      final int min = start;
      final int max = stop / step;
      return new java.util.Iterator<java.lang.Integer>() {
        private int current = min;

        @java.lang.Override
        public boolean hasNext() {
          return current < max;
        }

        @java.lang.Override
        public java.lang.Integer next() {
          if (Class_.Test$Range$1.hasNext()) {
            return (current++) * step;
          } else {
            throw new java.util.NoSuchElementException("Range reached the end");
          }
        }

        @java.lang.Override
        public void remove() {
          throw new java.lang.UnsupportedOperationException("Can't remove values from a Range");
        }
      };
    }
  }
}

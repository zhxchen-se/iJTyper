class Test {
    public static void main(java.lang.String[] args) {
        int[] solutionArray = new int[]{ 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };
        Class_.Test.shuffleArray(solutionArray);
        for (int i = 0; i < solutionArray.length; i++) {
            java.lang.System.out.print(solutionArray[i] + " ");
        }
        java.lang.System.out.println();
    }

    static void shuffleArray(int[] ar) {
        java.util.Random rnd = java.util.concurrent.ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    protected static java.util.List<java.lang.Integer> range(int n) {
        return Class_.Test.toList(new Class_.Test.Range(n), new java.util.ArrayList<java.lang.Integer>());
    }

    protected static <T> java.util.List<T> toList(java.lang.Iterable<T> iterable) {
        return Class_.Test.toList(iterable, new java.util.ArrayList<T>());
    }

    protected static <T> java.util.List<T> toList(java.lang.Iterable<T> iterable, java.util.List<T> destination) {
        Class_.Test.addAll(destination, iterable.iterator());
        return destination;
    }

    protected static <T> void addAll(java.util.Collection<T> collection, java.util.Iterator<T> iterator) {
        while (iterator.hasNext()) {
            collection.add(iterator.next());
        } 
    }

    private static class Range implements java.lang.Iterable<java.lang.Integer> {
        private int start;

        private int stop;

        private int step;

        private Range(int n) {
            this(0, n, 1);
        }

        private Range(int start, int stop) {
            this(start, stop, 1);
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
                    if (hasNext()) {
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


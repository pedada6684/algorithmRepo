import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> parent;
    public static void main(String[] code) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] minsuCard = new int[M];
        //카드 입력, 정렬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            minsuCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(minsuCard);

        //철수카드 입력
        Integer[] chalsuCard = new Integer[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            chalsuCard[i] = Integer.parseInt(st.nextToken());
        }
        //철수카드 복사, 중복제거, 정렬
        List<Integer> sortedChalsuCard = new ArrayList<>(new HashSet<>(Arrays.asList(chalsuCard)));
        Collections.sort(sortedChalsuCard);

        //찰수카드 별 queue map
        Map<Integer, Queue<Integer>> queueMap = new HashMap<>();

        //카드별 queue 할당
        int minsuCardIdx = 0;
        parent = new HashMap<>();
        for (int i = 0; i < sortedChalsuCard.size(); i++) {
            Integer now = sortedChalsuCard.get(i);
            Integer next = i+1 < sortedChalsuCard.size()?
                    sortedChalsuCard.get(i + 1) : Integer.MAX_VALUE;
            while (minsuCard[minsuCardIdx] <= now) minsuCardIdx++; //첫번째 구간까지 건너뛰기 /이분탐색으로 최적화 가능

            Queue<Integer> queue = new LinkedList<>();//큐 생성, 삽입
            while (minsuCardIdx < minsuCard.length && minsuCard[minsuCardIdx] <= next) {
                queue.add(minsuCard[minsuCardIdx++]);
            }

            queueMap.put(i, queue);
            parent.put(i,i);
        }

        //출력
        for (Integer cc : chalsuCard) {
            int sortedIdx = Collections.binarySearch(sortedChalsuCard, cc);
            Queue<Integer> queue = queueMap.get(find(sortedIdx));
            while (queue.isEmpty()){ // 큐가 빈경우 다음 구간으로 넘어감
                parent.put(find(sortedIdx), find(sortedIdx+1));
                queue = queueMap.get(find(sortedIdx));
                sortedIdx = find(sortedIdx);
            }
            sb.append(queue.poll()+"\n");
        }

        System.out.println(sb.toString().trim());
    }

    private static int find(Integer idx) {
        if (parent.get(idx) != idx){
            parent.put(idx, find(parent.get(idx)));
        }
        return parent.get(idx);
    }
}
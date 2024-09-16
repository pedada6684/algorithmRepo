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
        int[] card = new int[M];
        //카드 입력, 정렬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        //라운드 입력
        Integer[] question = new Integer[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            question[i] = Integer.parseInt(st.nextToken());
        }
        //라운드 복사, 중복제거, 정렬
        List<Integer> sortedQuestion = new ArrayList<>(new HashSet<>(Arrays.asList(question)));
        Collections.sort(sortedQuestion);

        //라운드 별 queue map
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        //라운드 분할
        int idx = 0;
        parent = new HashMap<>();
        for (int i = 0; i < sortedQuestion.size() - 1; i++) {
            Integer now = sortedQuestion.get(i);
            Integer next = sortedQuestion.get(i + 1);
            while (card[idx] <= now) idx++; //첫번째 구간까지 건너뛰기 /이분탐색으로 최적화 가능

            Queue<Integer> queue = new LinkedList<>();//큐 생성, 삽입
            while (idx < card.length && card[idx] <= next) {
                queue.add(card[idx++]);
            }

            map.put(i, queue);
            parent.put(i,i);
        }

        //마지막 구간 추가
        Queue<Integer> queue = new LinkedList<>();
        int lastIdx = sortedQuestion.size() - 1;
        while (card[idx] <= sortedQuestion.get(lastIdx)) idx++; //첫번째 구간까지 건너뛰기 /이분탐색으로 최적화 가능
        while (idx < card.length) {
            queue.add(card[idx++]);
        }
        map.put(lastIdx, queue);
        parent.put(lastIdx, lastIdx);

        //출력
        for (Integer q : question) {
            int idxQ = Collections.binarySearch(sortedQuestion, q);
            queue = map.get(find(idxQ));
            while (queue.isEmpty()){ // 큐가 빈경우 다음 구간으로 넘어감
                union(idxQ, idxQ+1);
                queue = map.get(find(idxQ));
                idxQ = find(idxQ);
            }
            sb.append(queue.poll()+"\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static void union(int f, int b) {
        if (find(f) == find(b))return;
        parent.put(find(f), find(b));
    }

    private static int find(Integer idx) {
        if (parent.get(idx) != idx){
            parent.put(idx, find(parent.get(idx)));
        }
        return parent.get(idx);
    }
}
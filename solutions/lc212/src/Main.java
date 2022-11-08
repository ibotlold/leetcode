import java.util.*;

public class Main {
    public static void main(String[] args) {
//        new Solution().findWords(new char[][]{
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        }, new String[]{
//                "oath",
//                "pea",
//                "eat",
//                "rain"
//        });
//        new Solution().findWords(new char[][]{
//                {'a','b'},
//                {'c','d'}
//        }, new String[]{
//                "abcb"
//        });
//        new Solution().findWords(new char[][]{
//                {'a','a'},
//        }, new String[]{
//                "aa"
//        });
//        new Solution().findWords(new char[][]{
//                {'a','b','c'},
//                {'a','e','d'},
//                {'a','f','g'}
//        }, new String[]{
//                "abcdefg",
//                "gfedcbaaa",
//                "eaabcdgfa",
//                "befa",
//                "dgc",
//                "ade"
//        });
        new Solution().findWords(new char[][]{
                {'a'}
        }, new String[]{
                "ab"
        });
    }
}
/*
[["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"]]
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

[["b","a","b","a","b","a","b","a","b","a"],["a","b","a","b","a","b","a","b","a","b"],["b","a","b","a","b","a","b","a","b","a"],["a","b","a","b","a","b","a","b","a","b"],["b","a","b","a","b","a","b","a","b","a"],["a","b","a","b","a","b","a","b","a","b"],["b","a","b","a","b","a","b","a","b","a"],["a","b","a","b","a","b","a","b","a","b"],["b","a","b","a","b","a","b","a","b","a"],["a","b","a","b","a","b","a","b","a","b"]]
["ababababaa","ababababab","ababababac","ababababad","ababababae","ababababaf","ababababag","ababababah","ababababai","ababababaj","ababababak","ababababal","ababababam","ababababan","ababababao","ababababap","ababababaq","ababababar","ababababas","ababababat","ababababau","ababababav","ababababaw","ababababax","ababababay","ababababaz","ababababba","ababababbb","ababababbc","ababababbd","ababababbe","ababababbf","ababababbg","ababababbh","ababababbi","ababababbj","ababababbk","ababababbl","ababababbm","ababababbn","ababababbo","ababababbp","ababababbq","ababababbr","ababababbs","ababababbt","ababababbu","ababababbv","ababababbw","ababababbx","ababababby","ababababbz","ababababca","ababababcb","ababababcc","ababababcd","ababababce","ababababcf","ababababcg","ababababch","ababababci","ababababcj","ababababck","ababababcl","ababababcm","ababababcn","ababababco","ababababcp","ababababcq","ababababcr","ababababcs","ababababct","ababababcu","ababababcv","ababababcw","ababababcx","ababababcy","ababababcz","ababababda","ababababdb","ababababdc","ababababdd","ababababde","ababababdf","ababababdg","ababababdh","ababababdi","ababababdj","ababababdk","ababababdl","ababababdm","ababababdn","ababababdo","ababababdp","ababababdq","ababababdr","ababababds","ababababdt","ababababdu","ababababdv","ababababdw","ababababdx","ababababdy","ababababdz","ababababea","ababababeb","ababababec","ababababed","ababababee","ababababef","ababababeg","ababababeh","ababababei","ababababej","ababababek","ababababel","ababababem","ababababen","ababababeo","ababababep","ababababeq","ababababer","ababababes","ababababet","ababababeu","ababababev","ababababew","ababababex","ababababey","ababababez","ababababfa","ababababfb","ababababfc","ababababfd","ababababfe","ababababff","ababababfg","ababababfh","ababababfi","ababababfj","ababababfk","ababababfl","ababababfm","ababababfn","ababababfo","ababababfp","ababababfq","ababababfr","ababababfs","ababababft","ababababfu","ababababfv","ababababfw","ababababfx","ababababfy","ababababfz","ababababga","ababababgb","ababababgc","ababababgd","ababababge","ababababgf","ababababgg","ababababgh","ababababgi","ababababgj","ababababgk","ababababgl","ababababgm","ababababgn","ababababgo","ababababgp","ababababgq","ababababgr","ababababgs","ababababgt","ababababgu","ababababgv","ababababgw","ababababgx","ababababgy","ababababgz","ababababha","ababababhb","ababababhc","ababababhd","ababababhe","ababababhf","ababababhg","ababababhh","ababababhi","ababababhj","ababababhk","ababababhl","ababababhm","ababababhn","ababababho","ababababhp","ababababhq","ababababhr","ababababhs","ababababht","ababababhu","ababababhv","ababababhw","ababababhx","ababababhy","ababababhz","ababababia","ababababib","ababababic","ababababid","ababababie","ababababif","ababababig","ababababih","ababababii","ababababij","ababababik","ababababil","ababababim","ababababin","ababababio","ababababip","ababababiq","ababababir","ababababis","ababababit","ababababiu","ababababiv","ababababiw","ababababix","ababababiy","ababababiz","ababababja","ababababjb","ababababjc","ababababjd","ababababje","ababababjf","ababababjg","ababababjh","ababababji","ababababjj","ababababjk","ababababjl","ababababjm","ababababjn","ababababjo","ababababjp","ababababjq","ababababjr","ababababjs","ababababjt","ababababju","ababababjv","ababababjw","ababababjx","ababababjy","ababababjz","ababababka","ababababkb","ababababkc","ababababkd","ababababke","ababababkf","ababababkg","ababababkh","ababababki","ababababkj","ababababkk","ababababkl","ababababkm","ababababkn","ababababko","ababababkp","ababababkq","ababababkr","ababababks","ababababkt","ababababku","ababababkv","ababababkw","ababababkx","ababababky","ababababkz","ababababla","abababablb","abababablc","ababababld","abababable","abababablf","abababablg","abababablh","ababababli","abababablj","abababablk","ababababll","abababablm","ababababln","abababablo","abababablp","abababablq","abababablr","ababababls","abababablt","abababablu","abababablv","abababablw","abababablx","abababably","abababablz","ababababma","ababababmb","ababababmc","ababababmd","ababababme","ababababmf","ababababmg","ababababmh","ababababmi","ababababmj","ababababmk","ababababml","ababababmm","ababababmn","ababababmo","ababababmp","ababababmq","ababababmr","ababababms","ababababmt","ababababmu","ababababmv","ababababmw","ababababmx","ababababmy","ababababmz","ababababna","ababababnb","ababababnc","ababababnd","ababababne","ababababnf","ababababng","ababababnh","ababababni","ababababnj","ababababnk","ababababnl","ababababnm","ababababnn","ababababno","ababababnp","ababababnq","ababababnr","ababababns","ababababnt","ababababnu","ababababnv","ababababnw","ababababnx","ababababny","ababababnz","ababababoa","ababababob","ababababoc","ababababod","ababababoe","ababababof","ababababog","ababababoh","ababababoi","ababababoj","ababababok","ababababol","ababababom","ababababon","ababababoo","ababababop","ababababoq","ababababor","ababababos","ababababot","ababababou","ababababov","ababababow","ababababox","ababababoy","ababababoz","ababababpa","ababababpb","ababababpc","ababababpd","ababababpe","ababababpf","ababababpg","ababababph","ababababpi","ababababpj","ababababpk","ababababpl","ababababpm","ababababpn","ababababpo","ababababpp","ababababpq","ababababpr","ababababps","ababababpt","ababababpu","ababababpv","ababababpw","ababababpx","ababababpy","ababababpz","ababababqa","ababababqb","ababababqc","ababababqd","ababababqe","ababababqf","ababababqg","ababababqh","ababababqi","ababababqj","ababababqk","ababababql","ababababqm","ababababqn","ababababqo","ababababqp","ababababqq","ababababqr","ababababqs","ababababqt","ababababqu","ababababqv","ababababqw","ababababqx","ababababqy","ababababqz","ababababra","ababababrb","ababababrc","ababababrd","ababababre","ababababrf","ababababrg","ababababrh","ababababri","ababababrj","ababababrk","ababababrl","ababababrm","ababababrn","ababababro","ababababrp","ababababrq","ababababrr","ababababrs","ababababrt","ababababru","ababababrv","ababababrw","ababababrx","ababababry","ababababrz","ababababsa","ababababsb","ababababsc","ababababsd","ababababse","ababababsf","ababababsg","ababababsh","ababababsi","ababababsj","ababababsk","ababababsl","ababababsm","ababababsn","ababababso","ababababsp","ababababsq","ababababsr","ababababss","ababababst","ababababsu","ababababsv","ababababsw","ababababsx","ababababsy","ababababsz","ababababta","ababababtb","ababababtc","ababababtd","ababababte","ababababtf","ababababtg","ababababth","ababababti","ababababtj","ababababtk","ababababtl","ababababtm","ababababtn","ababababto","ababababtp","ababababtq","ababababtr","ababababts","ababababtt","ababababtu","ababababtv","ababababtw","ababababtx","ababababty","ababababtz","ababababua","ababababub","ababababuc","ababababud","ababababue","ababababuf","ababababug","ababababuh","ababababui","ababababuj","ababababuk","ababababul","ababababum","ababababun","ababababuo","ababababup","ababababuq","ababababur","ababababus","ababababut","ababababuu","ababababuv","ababababuw","ababababux","ababababuy","ababababuz","ababababva","ababababvb","ababababvc","ababababvd","ababababve","ababababvf","ababababvg","ababababvh","ababababvi","ababababvj","ababababvk","ababababvl","ababababvm","ababababvn","ababababvo","ababababvp","ababababvq","ababababvr","ababababvs","ababababvt","ababababvu","ababababvv","ababababvw","ababababvx","ababababvy","ababababvz","ababababwa","ababababwb","ababababwc","ababababwd","ababababwe","ababababwf","ababababwg","ababababwh","ababababwi","ababababwj","ababababwk","ababababwl","ababababwm","ababababwn","ababababwo","ababababwp","ababababwq","ababababwr","ababababws","ababababwt","ababababwu","ababababwv","ababababww","ababababwx","ababababwy","ababababwz","ababababxa","ababababxb","ababababxc","ababababxd","ababababxe","ababababxf","ababababxg","ababababxh","ababababxi","ababababxj","ababababxk","ababababxl","ababababxm","ababababxn","ababababxo","ababababxp","ababababxq","ababababxr","ababababxs","ababababxt","ababababxu","ababababxv","ababababxw","ababababxx","ababababxy","ababababxz","ababababya","ababababyb","ababababyc","ababababyd","ababababye","ababababyf","ababababyg","ababababyh","ababababyi","ababababyj","ababababyk","ababababyl","ababababym","ababababyn","ababababyo","ababababyp","ababababyq","ababababyr","ababababys","ababababyt","ababababyu","ababababyv","ababababyw","ababababyx","ababababyy","ababababyz","ababababza","ababababzb","ababababzc","ababababzd","ababababze","ababababzf","ababababzg","ababababzh","ababababzi","ababababzj","ababababzk","ababababzl","ababababzm","ababababzn","ababababzo","ababababzp","ababababzq","ababababzr","ababababzs","ababababzt","ababababzu","ababababzv","ababababzw","ababababzx","ababababzy","ababababzz"]
 */

class Solution {
    HashSet<String> result = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word :
                words) {
            trie.insert(word);
        }
        int height = board.length;
        int width = board[0].length;
        for (String word :
                words) {
            for (int i = 0; i < height && !result.contains(word); i++) {
                for (int j = 0; j < width && !result.contains(word); j++) {
                    int[] root = new int[]{i, j};
                    int[][] path = new int[][]{ root };
                    backtrack(board, word, trie, path, root);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void backtrack(char[][] board, String word, Trie trie, int[][] path, int[] cell) {
        char[] charFromPath = new char[path.length];
        for (int i = 0; i < path.length; i++) {
            charFromPath[i] = board[path[i][0]][path[i][1]];
            if (charFromPath[i] != word.charAt(i)) return;
        }
        Trie.Node node = trie.getNode(charFromPath);
        if (node == null) return;
        if (node.value != null && node.value.equals(word)) {
            result.add(word);
            trie.remove(word);
            return;
        }
        int[][] neighbours = getNeighbours(board, cell);
        if (neighbours == null) return;
        for (int k = 0; k < neighbours.length && !result.contains(word); k++) {
            int[] nextCell = new int[]{neighbours[k][0], neighbours[k][1]};
            boolean visited = false;
            for (int i = 0; i < path.length; i++) {
                if (!Arrays.equals(path[i], nextCell)) continue;
                visited = true;
                break;
            }
            if (visited) continue;
            int[][] newPath = pushCell(path, nextCell);
            backtrack(board, word, trie, newPath, nextCell);
        }
    }

    private int[][] pushCell(int[][] path, int[] nextCell) {
        int[][] newPath = new int[path.length + 1][2];
        System.arraycopy(path, 0, newPath, 0, path.length);
        newPath[path.length] = nextCell;
        return newPath;
    }

    private int[][] getNeighbours(char[][] board, int[] cell) {
        int i = cell[0];
        int j = cell[1];
        int rowCount = board.length;
        if (i < 0 || i > rowCount) return null;
        int columnCount = board[0].length;
        if (j < 0 || j > columnCount) return null;
        int rowNeighbourCount = 2;
        int columnNeighbourCount = 2;
        if (i == 0) rowNeighbourCount--;
        if (i == rowCount - 1) rowNeighbourCount--;
        if (j == 0) columnNeighbourCount--;
        if (j == columnCount - 1) columnNeighbourCount--;
        int size = rowNeighbourCount + columnNeighbourCount;
        if (size == 0) return null;
        int[][] neighbours = new int[size][2];
        int neighboursCounter = 0;
        //top
        if (i != 0) {
            neighbours[neighboursCounter] = new int[]{i - 1, j};
            neighboursCounter++;
        }
        //left
        if (j != 0) {
            neighbours[neighboursCounter] = new int[]{i, j - 1};
            neighboursCounter++;
        }
        //right
        if (j != columnCount - 1) {
            neighbours[neighboursCounter] = new int[]{i, j + 1};
            neighboursCounter++;
        }
        //down
        if (i != rowCount - 1) {
            neighbours[neighboursCounter] = new int[]{i + 1, j};
        }
        return neighbours;
    }

    class Trie {
        class Node {
            HashMap<Character,Node> childNodes = new HashMap<>();
            String value;
        }
        private Node root = new Node();

        public boolean insert(String value) {
            Node current = root;
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                current = current.childNodes.computeIfAbsent(ch, character -> new Node());
            }
            current.value = value;
            return true;
        }
        public void remove(String word) {
            Node root = this.root;
            trieDelete(root, new StringBuilder(word));
        }
        private Node trieDelete(Node current, StringBuilder key) {
            Node next = null;
            char firstChar = 0;
            if (!key.isEmpty()) {
                firstChar = key.charAt(0);
                next = current.childNodes.get(key.charAt(0));
                next = trieDelete(next, key.deleteCharAt(0));
            }
            if (next == null) {
                if (firstChar == 0) {
                    current.value = null;
                } else current.childNodes.remove(firstChar);
                if (current.childNodes.isEmpty() && current.value == null) return null;
            }
            return current;
        }
        private Node search(char[] charSequence) {
            Node current = root;
            for (int i = 0; i < charSequence.length; i++) {
                char ch = charSequence[i];
                Node node = current.childNodes.get(ch);
                if (node == null) return null;
                current = node;
            }
            return current;
        }
        public Node getNode(char[] charSequence) {
            Node node = search(charSequence);
            return node;
        }
    }


}
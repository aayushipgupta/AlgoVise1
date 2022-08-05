package com.example.algovise1.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.algovise1.Algorithm;
import com.example.algovise1.AlgorithmCode;
import com.example.algovise1.databinding.FragmentCodeBinding;

public class CodeFragment extends Fragment {

    LinearLayout codeLayout;
    private FragmentCodeBinding binding;

    public static CodeFragment newInstance(String algorithm) {
        CodeFragment fragment = new CodeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Algorithm.KEY_ALGORITHM, algorithm);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentCodeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void setCode(String key) {
        if (codeLayout != null) {
            codeLayout.removeAllViews();
            switch (key) {
                case Algorithm.BUBBLE_SORT:
                    addCodeItem(AlgorithmCode.CODE_BUBBLE_SORT, "Bubble sort");
                    break;
                case Algorithm.INSERTION_SORT:
                    addCodeItem(AlgorithmCode.CODE_INSERTION_SORT, "Insertion sort");
                    break;
                case Algorithm.SELECTION_SORT:
                    addCodeItem(AlgorithmCode.CODE_SELECTION_SORT,"Selection sort");
                    break;
                case Algorithm.QUICKSORT:
                    addCodeItem(AlgorithmCode.CODE_QUICKSORT, "Quicksort");
                    break;
                case Algorithm.BST_SEARCH:
                    addCodeItem(AlgorithmCode.CODE_BST_SEARCH, "BST Search");
                    break;
                case Algorithm.LINEAR_SEARCH:
                    addCodeItem(AlgorithmCode.CODE_LINEAR_SEARCH, "Linear Search");
                    break;
                case Algorithm.BST_INSERT:
                    addCodeItem(AlgorithmCode.CODE_BST_INSERT, "BST Insert");
                    break;
                case Algorithm.BINARY_SEARCH:
                    addCodeItem(AlgorithmCode.CODE_BINARY_SEARCH, "Binary search");
                    break;
                case Algorithm.LINKED_LIST:
                    addCodeItem(AlgorithmCode.CODE_LINKED_LIST_INSERT, "Linked list insert data");
                    addCodeItem(AlgorithmCode.CODE_LINKED_LIST_DELETE, "Linked list delete node");
                    break;
                case Algorithm.STACK:
                    addCodeItem(AlgorithmCode.CODE_STACK_PUSH, "Stack push");
                    addCodeItem(AlgorithmCode.CODE_STACK_POP, "Stack pop");
                    addCodeItem(AlgorithmCode.CODE_STACK_PEEK, "Stack peek");
                    break;
                case Algorithm.BFS:
                    addCodeItem(AlgorithmCode.CODE_GRAPH_BFS, "Breadth first search");
                    break;
                case Algorithm.DFS:
                    addCodeItem(AlgorithmCode.CODE_GRAPH_DFS, "Depth first search");
                    break;
                case Algorithm.BELLMAN_FORD:
                    addCodeItem(AlgorithmCode.CODE_BELLMAN_FORD, "Bellman Ford");
                    break;
                case Algorithm.DIJKSTRA:
                    addCodeItem(AlgorithmCode.CODE_DIJKSTRA, "Dijkstra");
                    break;
            }
        }

    }
    private void addCodeItem(String code, String title) {
        //View codeitem = LayoutInflater.from(getActivity()).inflate(R.layout.item_code_view, codeLayout, false);

        /*CodeView codeView = (CodeView) codeitem.findViewById(R.id.code_view);
        TextView titleText = (TextView) codeitem.findViewById(R.id.title);

        titleText.setText(title);

        codeView.setTheme(CodeViewTheme.GITHUB);
        codeView.setHorizontalScrollBarEnabled(true);

        codeView.setOnTouchListener(new HorizontalMoveListener());

        codeView.showCode(code);
*/
        //codeLayout.addView(codeitem);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
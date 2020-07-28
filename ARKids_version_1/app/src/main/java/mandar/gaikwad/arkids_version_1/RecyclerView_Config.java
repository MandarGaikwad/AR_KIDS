package mandar.gaikwad.arkids_version_1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mandar.gaikwad.arkids_version_1.Model.Question;


public class RecyclerView_Config {
    private Context mContext;
    private QuestionsAdapter mQuestionsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Question> questions, List<String> keys) {
        mContext = context;
        mQuestionsAdapter = new QuestionsAdapter(questions, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mQuestionsAdapter);
    }

    class QuestionItemView extends RecyclerView.ViewHolder {
        private TextView mQuestion;
        private TextView mAnswer;
        private TextView mOption1;
        private TextView mOption2;
        private TextView mOption3;
        private TextView mOption4;

        private String key;

        public QuestionItemView(ViewGroup parent) {
           super(LayoutInflater.from(mContext).inflate(R.layout.question_list_item, parent, false));

            mQuestion = (TextView) itemView.findViewById(R.id.title_txtView);
            mAnswer = (TextView) itemView.findViewById(R.id.answer_txtView);
            mOption1 = (TextView) itemView.findViewById(R.id.option1_txtView);
            mOption2 = (TextView) itemView.findViewById(R.id.option2_txtView);
            mOption3 = (TextView) itemView.findViewById(R.id.option3_txtView);
            mOption4 = (TextView) itemView.findViewById(R.id.option4_txtView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, QuestionDetailsActivity.class);
                    intent.putExtra("key", key);
                    intent.putExtra("question", mQuestion.getText().toString());
                    intent.putExtra("answer", mAnswer.getText().toString());
                    intent.putExtra("option 1", mOption1.getText().toString());
                    intent.putExtra("option 2", mOption2.getText().toString());
                    intent.putExtra("option 3", mOption3.getText().toString());
                    intent.putExtra("option 4", mOption4.getText().toString());

                    mContext.startActivity(intent);

                }
            });


        }

        public void bind(Question question, String key) {
            mQuestion.setText(question.getQuestion());
            mAnswer.setText(question.getAnswer());
            mOption1.setText(question.getOption1());
            mOption2.setText(question.getOption2());
            mOption3.setText(question.getOption3());
            mOption4.setText(question.getOption4());
            this.key = key;
        }
    }
    class QuestionsAdapter extends RecyclerView.Adapter<QuestionItemView>{
        private List<Question> mQuestionList;
        private List<String> mKeys;

        public QuestionsAdapter(List<Question> mQuestionList, List<String> mKeys) {
            this.mQuestionList = mQuestionList;
            this.mKeys = mKeys;
        }


        @Override
        public QuestionItemView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new QuestionItemView(parent);
        }

        @Override
        public void onBindViewHolder(QuestionItemView holder, int position) {
            holder.bind(mQuestionList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mQuestionList.size();
        }
    }

}

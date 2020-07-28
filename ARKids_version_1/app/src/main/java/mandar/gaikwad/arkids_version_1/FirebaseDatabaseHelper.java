package mandar.gaikwad.arkids_version_1;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mandar.gaikwad.arkids_version_1.Model.Question;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceQuestions;
    private List<Question> questions = new ArrayList<>();

    public interface DataStatus {
        void DataIsLoaded(List<Question> questions, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceQuestions = mDatabase.getReference().child("Questions");
    }

    public void readQuestions(final DataStatus dataStatus) {
        mReferenceQuestions.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    questions.clear(); //clrea list of questions from old data
                    List<String> keys = new ArrayList<>();
                    for (DataSnapshot keyNode : dataSnapshot.getChildren()) { //loopen door key values
                        keys.add(keyNode.getKey()); //opslaan aan de keys list
                        Question question = keyNode.getValue(Question.class);
                        questions.add(question);
                    }
                    dataStatus.DataIsLoaded(questions, keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateQuestion(String key, Question question, final DataStatus dataStatus) {
        mReferenceQuestions.child(key).setValue(question).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }
    public void deleteQuestion(String key, final DataStatus dataStatus) {
        mReferenceQuestions.getRef().setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}

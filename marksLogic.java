public class marksLogic {

        final private String subjectcode;
        final private int marksinth;
        final private int marksinpr;
        final private int marksinmt;
        final private int totalofmarks;

        marksLogic(String subjectcode,int marksinth, int marksinpr, int marksinmt, int totalofmarks){
            this.subjectcode = subjectcode;
            this.marksinth = marksinth;
            this.marksinpr = marksinpr;
            this.marksinmt = marksinmt;
            this.totalofmarks = totalofmarks;
        }

        public String getSubjectcode() {
            return subjectcode;
        }

        public int getMarksinth() {
            return marksinth;
        }

        public int getMarksinpr() {
            return marksinpr;
        }
        public int getMarksinmt() {
            return marksinmt;
        }
        public int getTotalofmarks() {
            return totalofmarks;
        }


    }


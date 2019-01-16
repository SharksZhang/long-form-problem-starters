package model;

import java.lang.ref.PhantomReference;
import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase> {

    private List<Phrase> phrases;

    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;

    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }

    @Override
    public Iterator<Phrase> iterator() {
        return new PhraseIterator();
    }

    private class PhraseIterator implements Iterator<Phrase> {
        Iterator<Phrase> phraseIterator = phrases.iterator();
        private int numWordsNeeded;

        public PhraseIterator() {
            calculateNumWordsNeeded();
        }

        @Override
        public boolean hasNext() {
            if (numWordsNeeded >0){
                return true;
            }
            return false;
        }

        @Override
        public Phrase next() {
            Phrase phrase = this.phraseIterator.next();
            while (!phrase.needsWord()){
                phrase = phraseIterator.next();
            }
            numWordsNeeded--;
            return phrase;
        }

        private void calculateNumWordsNeeded() {
            Iterator<Phrase> it = phrases.iterator();
            while(it.hasNext()) {
                if (it.next().needsWord())
                    numWordsNeeded++;
            }
        }
    }
}

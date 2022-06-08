package ipvc.cm.cm_aulas.repository

import androidx.annotation.WorkerThread
import ipvc.cm.cm_aulas.dao.WordDao
import ipvc.cm.cm_aulas.model.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
package ipvc.cm.cm_aulas

import android.app.Application
import ipvc.cm.cm_aulas.db.WordRoomDatabase
import ipvc.cm.cm_aulas.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope)}
    val repository by lazy { WordRepository(database.wordDao()) }
}
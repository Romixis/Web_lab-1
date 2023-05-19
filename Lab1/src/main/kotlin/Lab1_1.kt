data class Contact(val name: String, val phoneNumber: String)

class MobilePhone {

    private val Contacts = ArrayList<Contact>()

    fun addNewContact(contact: Contact): Boolean {
        if (findContact(contact) >= 0) {
            println("Контакт есть")
            return false
        }
        Contacts.add(contact)
        return true
    }

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean {
        val position = findContact(oldContact)
        if (position < 0) {
            println("Контакта нет")
            return false
        }
        val name = Contacts[position].name
        Contacts[position] = newContact
        println("Контакт $name обновлён")
        return true
    }

    fun removeContact(contact: Contact): Boolean {
        val position = findContact(contact)
        if (position < 0) {
            println("Контакта нет")
            return false
        }
        val name = Contacts[position].name
        Contacts.removeAt(position)
        println("Контакт $name удалён")
        return true
    }

    private fun findContact(contact: Contact): Int {
        return Contacts.indexOf(contact)
    }

    fun queryContact(name: String): Contact? {
        for (i in Contacts.indices) {
            val contact = Contacts[i]
            if (contact.name == name) {
                println("Контакт $name найден:")
                println("${Contacts[i].name} -> ${Contacts[i].phoneNumber}")
                return contact
            }
        }
        println("Контакт $name не найден")
        return null
    }

    fun printContacts() {
        println("Список контактов:")
        for (i in Contacts.indices) {
            println("${i + 1}. ${Contacts[i].name} -> ${Contacts[i].phoneNumber}")
        }
    }
}

fun main() {
    val mobilePhone = MobilePhone()
    mobilePhone.addNewContact(Contact("Роман", "88005553535"))
    mobilePhone.addNewContact(Contact("Вован", "87774445588"))
    mobilePhone.printContacts()
    println()
    mobilePhone.updateContact(Contact("Роман", "88005553535"), Contact("Эдик", "89996785245"))
    println()
    mobilePhone.printContacts()
    println()
    mobilePhone.removeContact(Contact("Вован", "87774445588"))
    println()
    mobilePhone.printContacts()
    println()
    mobilePhone.queryContact("Эдик")
}
fun main(args: Array<String>) {
    println("---------------------------------------")
    println("Exercicío 1")
    //Ex.1
    println(isOddOrEven(3))

    println("---------------------------------------")
    println("Exercicío 2")
    //Ex.2
    val numbers = intArrayOf(7, 8, 12, 18, 2)
    val max = findMax(numbers)
    println(max)

    println("---------------------------------------")
    println("Exercicío 3")
    //Ex.3
    val pessoas = listOf(
        Pessoa("Bernardo", 20),
        Pessoa("Lucas", 19),
        Pessoa("Amanda", 22),
        Pessoa("Rafael", 28)
    )

    val pessoasOrdenadas = pessoas.sortedBy { it.nome }

    for (pessoa in pessoasOrdenadas) {
        println("${pessoa.nome}")
    }

    println("---------------------------------------")
    //Ex.4
    println("Exercicío 4")
    println(isPalindrome("natan"))

    println("---------------------------------------")
    //Ex.5
    println("Exercicío 5")
    val conta = ContaBancaria(100.0)
    conta.saldo = 500.0

    try {
        conta.saque(700.0)
    } catch (e: Exception) {
        println(e.message)
    }

    println("---------------------------------------")
    //Ex.6
    println("Exercicío 6")
    val lista = listOf("Computador", "Mesa", "Celular", "Gabinete")
    println(stringMaisLonga(lista))

    println("---------------------------------------")
    //Ex.7
    println("Exercicío 7")
    val list = listOf(
        Funcionario("Bernardo", 30, 5000.0),
        Funcionario("Amanda", 25, 7000.0),
        Funcionario("Pedro", 40, 4080.0),
        Funcionario("Anabelle", 35, 1200.0)
    )
    println(funcionarioMaiorSalario(list))

    println("---------------------------------------")
    //Ex.8
    println("Exercicío 8")
    val listaOrd = listOf(3, 5, 1, 4, 2)
    val listaOrdenada = ordenarLista(listaOrd)
    println(listaOrdenada)

    println("---------------------------------------")
    //Ex.9
    println("Exercicío 9")
    val t = Triangulo(6.0, 2.0)
    val area = t.area()
    println("A área do triângulo é $area")

    println("---------------------------------------")
    //Ex.10
    println("Exercicío 10")
    val strings = listOf("banana", "feijao", "arroz", "Amora", "Abobora")
    val filteredStrings = filterStringsStartingWithA(strings)
    println(filteredStrings)
}

fun isOddOrEven(number: Int): Boolean {
    return number % 2 == 0
}

fun findMax(numbers: IntArray): Int {
    var max = Int.MIN_VALUE
    for (number in numbers) {
        if (number > max) {
            max = number
        }
    }
    return max
}

class Pessoa(val nome: String, val idade: Int)

fun isPalindrome(str: String): Boolean {
    val reversed = str.reversed()
    return str == reversed
}

class ContaBancaria(val limite: Double) {
    var saldo = 0.0

    fun saque(valor: Double) {
        if (valor > saldo + limite) {
            throw RuntimeException("Saldo insuficiente")
        }
        saldo -= valor
    }
}

fun stringMaisLonga(strings: List<String>): String? {
    return strings.maxByOrNull { it.length }
}

data class Funcionario(val nome: String, val idade: Int, val salario: Double)

fun funcionarioMaiorSalario(funcionarios: List<Funcionario>): Funcionario? {
    return funcionarios.maxByOrNull { it.salario }
}

fun ordenarLista(lista: List<Int>): List<Int> {
    if (lista.size < 2) {
        return lista
    }

    val pivot = lista.first()
    val (menores, maiores) = lista.drop(1).partition { it < pivot }
    return ordenarLista(menores) + pivot + ordenarLista(maiores)
}

class Triangulo(val base: Double, val altura: Double) {
    fun area(): Double {
        return (base * altura) / 2
    }
}

fun filterStringsStartingWithA(strings: List<String>): List<String> {
    return strings.filter { it.startsWith('A', ignoreCase = true) }.sorted()
}
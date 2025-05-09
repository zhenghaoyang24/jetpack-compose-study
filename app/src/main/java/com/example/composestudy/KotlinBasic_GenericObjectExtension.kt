package com.example.composestudy

/**
 * 1.使用泛型创建可重复使用的类
 *
 * 使用泛型类型（简称“泛型”）时，可以使用数据类型（例如类）指定可与其属性和方法结合使用的未知占位符数据类型。
 */
class Question<T>(
    val questionText: String,
    val answer: T, val difficulty: Difficulty
)

/**
 * 2.枚举类
 * 枚举类用于创建具有一组数量有限的可能值的类型。
 * 枚举的每个可能值都称为“枚举常量”。枚举常量位于大括号内，互相以英文逗号分隔。按照惯例，常量名称中的每个字母都要大写。
 */
enum class Difficulty {
    EASY, MEDIUM, HARD
}

/**
 * 3.数据类
 *
 * 像 Question 这样的类只包含数据。它们没有任何用于执行操作的方法。这些类可以定义为“数据类”。
 * 通过将类定义为数据类，Kotlin 编译器可以做出某些假设，并自动实现某些方法。
 * 例如，println() 函数会在后台调用 toString()。当您使用数据类时，系统会根据类的属性自动实现 toString() 和其他方法。
 */
data class QuestionData<T>(
    val questionText: String, val answer: T, val difficulty: Difficulty
)

/**
 * 4.单例对象
 *
 * “单例”是指只能有一个实例的类。单例对象不能包含构造函数。所有属性都要在大括号内定义并被赋予初始值。
 */
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

/**
 * 4.1将对象声明为伴生对象
 *
 * 使用“伴生对象”在另一个类中定义单例对象。伴生对象允许您从类内部访问其属性和方法（如果对象的属性和方法属于相应类的话），
 * 从而让语法变得更简洁。
 *
 * 如需声明伴生对象，只需在 object 关键字前面添加 companion 关键字即可。
 */
class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 =
        Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

}

/**
 * **5.扩展类**
 *
 * **5.1扩展类的扩展属性**
 *
 * 不管是扩展函数 , 还是扩展属性 , 都没有将扩展的成员加入到类中 , 扩展属性没有 幕后字段 ;
 * 由于没有幕后字段 , 因此不能定义属性的初始化器 , 那么就必须处理初始化问题 , 必须定义其 get / set 访问器方法
 *
 */
//扩展变量属性。该属性是 var 修饰的扩展的变量属性 , 必须定义该属性的 get 和 set 属性访问器 ;
var Quiz.StudentProgress.totalAdd: Int
    get() {
        return this.total + 1
    }
    set(value) {
        this.total = value - 1
    }

//扩展常量属性。使用 val 修饰 , 因此其只能定义 get 属性访问方法
val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

/**
 * 5.2 **扩展类的扩展函数**
 *
 *  定义一个函数，在被定义的函数前面添加“类名.”，该函数即为该类名对应类的拓展方法。
 *
 *  便于通过类名访问，直接扩展伴生对象的函数
 */
fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.StudentProgress.answered) { print("▓") }
    repeat(Quiz.StudentProgress.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}

/**
 * 6.使用接口重写函数与属性
 *
 * 如果您需要多个类具有相同的额外属性和方法（可能是行为方式不同），就可以使用接口定义这些属性和方法。
 *
 * 接口使用 interface 关键字定义，后跟大驼峰式命名法 (UpperCamelCase) 名称，再跟左大括号和右大括号。
 * 在大括号内，您可以定义任何符合接口标准的类必须实现的方法签名或 get-only 属性。
 *
 * 使用 override 进行重写
 */
interface User {
    val fullName: String
    fun printFullName()
}

class UserInfo : User {
    val firstName: String = "Joe"
    val secondName: String = "Belie"
    override val fullName: String
        get() = "$firstName.$secondName"

    override fun printFullName() {
        print("firstName:$firstName,secondName:$secondName")
    }
}

/**
 * 7.使用作用域函数来访问类属性和方法  [作用域函数](https://kotlinlang.org/docs/scope-functions.html)
 *
 * 作用域函数属于高阶函数，允许您在不引用对象名称的情况下访问对象的属性和方法。
 * 有些作用域函数允许您访问类中的属性和方法，就好像这些函数已被定义为相应类的方法一样。消除重复的对象引用
 *
 * 7.1 借助 let() 函数，使用标识符 it 来引用 lambda 表达式中的对象，而无需使用对象的实际名称。
 *
 * 7.2 借助 apply()，即使尚未将某个对象分配到变量，您也可以对此对象调用作用域函数。apply() 函数还会返回对相应对象的引用，以便将其存储在变量中。
 *
 */
class PrintQuestion {
    val question = Question<String>("Quoth the raven ___", "nevermore", Difficulty.EASY)

    //    fun printQuiz() {
//        println(question.questionText)
//        println(question.answer)
//        println(question.difficulty)
//        println()
//    }
    // 1. 借助 let() 函数，使用标识符 it 来引用 lambda 表达式中的对象，而无需使用对象的实际名称。
    fun printQuiz() {
        question.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()
        }
    }
    // 2, 在main中使用 apply() 在没有变量的情况下调用对象方法
}


fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.EASY)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.MEDIUM)
    val question3 =
        Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    // 访问类的属性
    println("访问类的属性")
    println(question1.questionText)

    // 访问数据类 自动toString
    println("访问数据类")
    val questionData = QuestionData<String>("Quoth the raven ___", "nevermore", Difficulty.EASY)
    print(questionData.questionText)

    // 访问单例对象的属性
    println("访问单例对象的属性")
    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")

    // 访问伴生对象 ,伴生对象属性可直接通过类型访问
    println("访问伴生对象")
    println("${Quiz.answered} of ${Quiz.total} answered.")

    // 访问扩展属性
    println("访问扩展属性")
    println(Quiz.StudentProgress.totalAdd)
    println(Quiz.StudentProgress.progressText)

    // 访问扩展方法
    println("访问扩展方法")
    println(Quiz.StudentProgress.printProgressBar())

    // 访问重写方法
    println("访问重写方法")
    val userInfo = UserInfo()
    println(userInfo.fullName)
    println(userInfo.printFullName())

    println("使用作用域函数来访问类属性和方法")
    // 1. let()
    val printQuestion = PrintQuestion()
    printQuestion.printQuiz()
    // 2.apply()  可以在调用 apply() 时省略圆括号，并使用尾随 lambda 语法。
    val printQuestion2 = PrintQuestion().apply {
        printQuiz()
    }
    // 省略 PrintQuestion 实例
    PrintQuestion().apply {
        printQuiz()
    }

    println()
}
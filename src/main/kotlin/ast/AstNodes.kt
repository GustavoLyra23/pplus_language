package org.gustavolyra.ast

import org.gustavolyra.lexer.Token

//Este que serve como base para todos os elemtnos da arvore AST..
sealed class AstNode {
    abstract val tokenOriginador: Token?
}

//Program representa uma lista de declaracoes/comandos
data class Program(
    val declarations: List<Declaration>
) : AstNode() {
    override val tokenOriginador: Token? = declarations.firstOrNull()?.tokenOriginador
}

sealed class Declaration : AstNode()

data class VariableDeclaration(
    val name: Token,
    val typeDecl: AstNodeType?,
    val initializer: Expression?,
    override val tokenOriginador: Token
) : Declaration()

data class FunctionDeclaration(
    val name: Token,
    val parameters: List<FunctionParameter>,
    val returnType: AstNodeType?,
    val body: Block,
    override val tokenOriginador: Token
) : Declaration()

data class FunctionParameter(
    val name: Token,
    val typeDecl: AstNodeType?,
    val defaultValue: Expression?
)

data class ClassDeclaration(
    val name: Token,
    val superClass: Variable? = null,
    val members: List<Declaration>,
    override val tokenOriginador: Token
) : Declaration()

// Os comandos...

sealed class Command : Declaration()

data class Block(
    val declarations: List<Declaration>,
    override val tokenOriginador: Token
) : Command()

data class CommandExpression(
    val expression: Expression,
    override val tokenOriginador: Token
) : Command()

data class ShowCommand(
    val expression: Expression,
    override val tokenOriginador: Token
) : Command()

data class CommandRead(
    val targetVariable: Variable,
    override val tokenOriginador: Token
) : Command()

data class IfCommand(
    val condition: Expression,
    val thenBlock: Block,
    val ifelseBlock: Command?,
    override val tokenOriginador: Token
) : Command()

data class WhileCommand(
    val condition: Expression,
    val body: Block,
    override val tokenOriginador: Token
) : Command()

data class ForCommand(
    val initializer: Declaration?,
    val condition: Expression?,
    val increment: Expression?,
    val body: Block,
    override val tokenOriginador: Token
) : Command()

data class ReturnCommand(
    val value: Expression?,
    override val tokenOriginador: Token
) : Command()

sealed class Expression : AstNode()

data class Literal(
    val value: Any?,
    override val tokenOriginador: Token
) : Expression()

data class Variable(
    val name: Token,
    override val tokenOriginador: Token = name
) : Expression()

data class Assignment(
    val target: Expression,
    val value: Expression,
    override val tokenOriginador: Token
) : Expression()

data class Binary(
    val left: Expression,
    val operator: Token,
    val right: Expression,
    override val tokenOriginador: Token = operator
) : Expression()

data class Unary(
    val operator: Token,
    val right: Expression,
    override val tokenOriginador: Token = operator
) : Expression()

//classe para lidar com e, ou, xou, nao..
//TODO: nome da classe pode ser refatorado para "LogicalOperation" ou algo assim...
data class Logic(
    val left: Expression,
    val operator: Token,
    val right: Expression,
    override val tokenOriginador: Token = operator
) : Expression()

data class FunctionCall(
    val callee: Expression,
    val arguments: List<Expression>,
    val parenthesisDir: Token,
    override val tokenOriginador: Token
) : Expression()

data class ClassInstance(
    val className: Token,
    val constructorArguments: List<Expression>,
    override val tokenOriginador: Token
) : Expression()

data class MemberAcess(
    val objct: Expression,
    val member: Token,
    override val tokenOriginador: Token = member
) : Expression()

data class Grouping(val expression: Expression, override val tokenOriginador: Token) :
    Expression()

sealed class AstNodeType : AstNode() {
    abstract val tokenTypeName: Token?
    override val tokenOriginador: Token?
        get() = tokenTypeName
}

data class SimpleType(
    override val tokenTypeName: Token
) : AstNodeType()

data class ListType(
    val elementType: AstNodeType,
    override val tokenTypeName: Token
) : AstNodeType()

data class MapType(
    val keyType: AstNodeType,
    val valueType: AstNodeType,
    override val tokenTypeName: Token
) : AstNodeType()
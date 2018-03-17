package jwt
import java.security.KeyPairGenerator
import pdi.jwt.JwtAlgorithm.RS512
import pdi.jwt._
import pdi.jwt.JwtUtils._
/*
created by Ilya Volynin at 16.03.18
*/
object Common extends App {
  val data = "test"
  val data2 = "test2"
  val generatorRSA = KeyPairGenerator.getInstance(JwtUtils.RSA, JwtUtils.PROVIDER)
  generatorRSA.initialize(1024)
  val randomRSAKey = generatorRSA.generateKeyPair()
  println(s"public key: ${randomRSAKey.getPublic.toString}")
  println(s"private key: ${randomRSAKey.getPrivate.toString}")
  val signedData = JwtUtils.sign(data, randomRSAKey.getPrivate, RS512)
  println(s"signed data: ${stringify(signedData)}")
  val result = JwtUtils.verify(bytify(data), signedData, randomRSAKey.getPublic, RS512)
  println(s"result: $result")
  val result2 = JwtUtils.verify(bytify(data2), signedData, randomRSAKey.getPublic, RS512)
  println(s"result with a different source: $result2")
}

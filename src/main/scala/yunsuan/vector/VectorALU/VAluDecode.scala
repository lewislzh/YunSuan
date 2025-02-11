
package yunsuan.vector.alu

import chisel3._
import chisel3.util._
import chisel3.util.experimental.decode._

object VAluOpcode {
  val vadd   = 0.U(6.W)
  val vsub   = 1.U(6.W)
  val vext   = 2.U(6.W)
  val vadc   = 3.U(6.W)
  val vmadc  = 4.U(6.W)
  val vsbc   = 5.U(6.W)
  val vmsbc  = 6.U(6.W)
  val vand   = 7.U(6.W)
  val vnand  = 8.U(6.W)
  val vandn  = 9.U(6.W)
  val vxor   = 10.U(6.W)
  val vor    = 11.U(6.W)
  val vnor   = 12.U(6.W)
  val vorn   = 13.U(6.W)
  val vxnor  = 14.U(6.W)
  val vsll   = 15.U(6.W)
  val vsrl   = 16.U(6.W)
  val vsra   = 17.U(6.W)
  val vmseq  = 18.U(6.W)
  val vmsne  = 19.U(6.W)
  val vmslt  = 20.U(6.W)
  val vmsle  = 21.U(6.W)
  val vmsgt  = 22.U(6.W)
  val vmin   = 23.U(6.W)
  val vmax   = 24.U(6.W)
  val vmerge = 25.U(6.W)
  val vmv    = 26.U(6.W)
  val vsadd  = 27.U(6.W)
  val vssub  = 28.U(6.W)
  val vaadd  = 29.U(6.W)
  val vasub  = 30.U(6.W)
  val vssrl  = 31.U(6.W)
  val vssra  = 32.U(6.W)
  val vredsum = 33.U(6.W)
  val vredmax = 34.U(6.W)
  val vredmin = 35.U(6.W)
  val vredand = 36.U(6.W)
  val vredor  = 37.U(6.W)
  val vredxor = 38.U(6.W)
  val vcpop   = 39.U(6.W)
  val vfirst  = 40.U(6.W)
  val vmsbf   = 41.U(6.W)
  val vmsif   = 42.U(6.W)
  val vmsof   = 43.U(6.W)
  val viota   = 44.U(6.W)
  val vid     = 45.U(6.W)
  val vmvsx   = 46.U(6.W)
}

import VAluOpcode._

object VIntFixpTable {
                   //           misc
                   //         sub | cmp
                   //          |  |  |
  val default =       BitPat("b?  1  0")
  val table   = Seq(
    BitPat(vadd)   -> BitPat("b0  0  0"),
    BitPat(vsub)   -> BitPat("b1  0  0"),
    BitPat(vadc)   -> BitPat("b0  0  0"),
    BitPat(vmadc)  -> BitPat("b0  0  1"),
    BitPat(vsbc)   -> BitPat("b1  0  0"),
    BitPat(vmsbc)  -> BitPat("b1  0  1"),
    BitPat(vmseq)  -> BitPat("b?  0  1"),
    BitPat(vmsne)  -> BitPat("b?  0  1"),
    BitPat(vmslt)  -> BitPat("b1  0  1"),
    BitPat(vmsle)  -> BitPat("b1  0  1"),
    BitPat(vmsgt)  -> BitPat("b1  0  1"),
    BitPat(vmin)   -> BitPat("b1  0  0"),
    BitPat(vmax)   -> BitPat("b1  0  0"),
    BitPat(vsadd)  -> BitPat("b0  0  0"),
    BitPat(vssub)  -> BitPat("b1  0  0"),
    BitPat(vaadd)  -> BitPat("b0  0  0"),
    BitPat(vasub)  -> BitPat("b1  0  0"),
  )
}

// object VAluDecode {
//                       //             mask
//                       //          redu|
//                       //     IntFixp| | perm
//                       //          | | | |
//   val default =          BitPat("b? ? ? ?")
//   val table   = Seq(
//     BitPat(0.U(6.W))  -> BitPat("b1 0 0 0"),
//     BitPat(1.U(6.W))  -> BitPat("b1 0 0 0"),
//   )
// }

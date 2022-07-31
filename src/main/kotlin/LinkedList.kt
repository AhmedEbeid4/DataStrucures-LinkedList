class LinkedList {
    private var first:Node?=null
    private var last:Node?=null
    private var size:Int=0
    
    fun add(element: Int) {
        val a = Node(element)
        if (size == 0) {
            last = a
            first = last
        } else {
            a.next = first
            first = a
        }
        size++
    }
    fun addFromLast(item: Int) {
        val a = Node(item)
        if (size != 0) {
            last!!.next = a
            last = a
        } else {
            last = a
            first = last
        }
        size++
    }

    fun addAtPosition(item: Int, position: Int) {
        val a = Node(item)
        var b: Node? = null
        var c: Node? = null
        var ad = first
        if (position > 1 && position <= size - 2) {
            for (i in 0 until position) {
                ad = ad!!.next
                if (i == position - 1) {
                    c = ad
                }
                if (i == position - 2) {
                    b = ad
                }
            }
            b!!.next = a
            a.next = c
            size++
        } else {
            if (size > 1) {
                val f = first!!.next
                if (position == 0) {
                    add(item)
                    size--
                } else if (position == 1) {
                    first!!.next = a
                    a.next = f
                } else if (position == 2 && size >= 2) {
                    val s = f!!.next
                    a.next = s
                    f.next = a
                } else if (position == size - 1) {
                    addFromLast(item)
                    size--
                }
                size++
            } else {
                println("Error")
            }
        }
    }

    fun remove(item: Int) {
        val a = Node(item)
        var ab = first
        var ac = first
        var r = true
        if (item != first!!.item && item != last!!.item) {
            for (i in 0 until size) {
                ab = ab!!.next
                if (ab!!.item === a.item) {
                    ac!!.next = ab!!.next
                    ab.next = null
                    r = false
                    break
                }
                ac = ac!!.next
            }
            if (r) {
                println("doesn't exist")
            }
        } else {
            if (item == first!!.item) {
                first = first!!.next
            } else if (item == last!!.item) {
                var we = first
                var i = 1
                while (true) {
                    we = we!!.next
                    if (i == size - 2) {
                        break
                    }
                    i++
                }
                last = we
                last!!.next = null
                size--
            }
        }
    }

    fun removeByPosition(position: Int) {
        if (position < 0 || position > size() - 1) {
        } else if (position == 0) {
            remove(first!!.item!!)
        } else if (position == size() - 1) {
            pop()
        } else {
            var we = first
            var q: Node? = null
            var wr = first
            for (i in 1 until size()) {
                we = we!!.next
                if (i == position) {
                    q = we!!.next
                    break
                }
                wr = wr!!.next
            }
            wr!!.next = q
            we!!.next = null
        }
    }

    fun pop() {
        remove(last!!.item!!)
    }

    fun getLast(): Int {
        return last!!.item!!
    }

    fun indexOf(item: Int): Int {
        var a = first
        var we = -1
        for (i in 0 until size) {
            if (a!!.item === item) {
                we = i
                break
            }
            a = a!!.next
        }
        return we
    }
    fun isEmpty():Boolean{
        return size==0
    }
    fun size():Int{
        return size
    }
}
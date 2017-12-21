NumpadEnd::Numpad1
NumpadDown::Numpad2
NumpadPgDn::Numpad3
NumpadLeft::Numpad4
NumpadClear::Numpad5
NumpadRight::Numpad6
NumpadHome::Numpad7
NumpadUp::Numpad8
NumpadPgUp::Numpad9
NumpadIns::Numpad0



*^!r::reload
Numpad7::playFile("f")
+Numpad7::playFile("f her right in the")
Numpad8::playFile("right in the")
Numpad9::playFile("p")
+Numpad9::playFile("p slow")
^+Numpad9::playFile("p slow low pitch")

Numpad4::playFile("smoke")
Numpad5::playFile("weed")
+Numpad5::playFile("weed slow")
Numpad6::playFile("everyday")

Numpad1::playFile("scary monsters snippet v2")
+Numpad1::playFile("yo skrill drop it hard")
^+Numpad1::playFile("skrillex drop the bass")
Numpad2::playFile("nuclear fart")
+Numpad2::playFile("nuclear fart slow")
Numpad3::playFile("dam")
NumpadDel::playFile("skrillex drop the bass continued")
+NumpadDel::playFile("fartstep repeatable 3")

Numpad0::playFile("moo")
NumpadEnter::playFileRandom("santa claus is coming home")

NumpadDiv::playFile("fartstep repeatable 1")
+NumpadDiv::playFile("fartstep repeatable 3")
NumpadMult::playFile("fartstep repeatable 2")
+NumpadMult::playFile("fartstep repeatable 4")
NumpadSub::playFile("fartstep transition 1")
+NumpadSub::playFile("fartstep transition 2")
^+NumpadSub::playFile("fartstep jeopardy")
NumpadAdd::playFile("fartstep ah ugh ah ugh")
+NumpadAdd::playFile("fartstep ah ugh ah ugh - skip 1")
^+NumpadAdd::playFile("fartstep ah ugh ah ugh - skip 2")

playFile(filename){
	WebRequest := ComObjCreate("WinHttp.WinHttpRequest.5.1")
	WebRequest.Open("GET", "http://localhost:4567/play?filename=" . filename)
	WebRequest.Send()
	return
}

playFileRandom(filename){
	WebRequest := ComObjCreate("WinHttp.WinHttpRequest.5.1")
	WebRequest.Open("GET", "http://localhost:4567/play-random?filename=" . filename)
	WebRequest.Send()
	return
}
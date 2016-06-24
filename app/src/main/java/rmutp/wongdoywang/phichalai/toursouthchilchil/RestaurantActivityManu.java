package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class RestaurantActivityManu extends AppCompatActivity {

    private ListView listView;
    private String name;

    String[] restaurantname;
    String[] restaurantimge;
    String[] restaurantimgeB;
    String[] restaurantimgeC;
    String[] restaurantdescription;
    String[] restaurantopen;
    String[] restaurantaddress;
    String[] restauranttravel;
    String[] restaurantprice;
    String[] resurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantmanu);

        name = getIntent().getStringExtra("name");


        //create ListView
        listView = (ListView) findViewById(R.id.listView4);

        showListTour();


      /*  Button Button52 = (Button) findViewById(R.id.button52);
        Button52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse("resurl") );
                startActivity( browse );
            }
        });*/
    }

    private void showListTour() {

        String temp_sql = null;

        switch (name) {

            case "เกาะไก่":
                temp_sql = " _id >= 0 AND _id <= 3";
                break;
            case "จุดดำน้ำหินกลาง":
                temp_sql = " _id >= 4 AND _id <= 6";
                break;
            case "ถนนคนเดินกระบี่":
                temp_sql = " _id >= 7 AND _id <= 9";
                break;
            case "ทะเลแหวก":
                temp_sql = " _id >= 10 AND _id <= 12";
                break;
            case "วัดถ้ำเสือเขาแก้ว":
                temp_sql = " _id >= 13 AND _id <= 15";
                break;
            case "ศูนย์วิจัยและพัฒนาประมงชายฝั่งกระบี่":
                temp_sql = " _id >= 16 AND _id <= 18";
                break;
            case "สระแก้ว":
                temp_sql = " _id >= 19 AND _id <= 21";
                break;
            case "สวนเจ้าฟ้าและสวนธารา":
                temp_sql = " _id >= 22 AND _id <= 24";
                break;
            case "สุสานหอยสี่สิบล้านปี":
                temp_sql = " _id >= 25 AND _id <= 27";
                break;
            case "หาดทับแขก":
                temp_sql = " _id >= 28 AND _id <= 30";
                break;
            case "หาดนพรัตน์ธารา":
                temp_sql = " _id >= 31 AND _id <= 33";
                break;
            case "อ่าวนาง":
                temp_sql = " _id >= 34 AND _id <= 36";
                break;
            case "อ่าวน้ำเมา":
                temp_sql = " _id >= 37 AND _id <= 39";
                break;
            case "อุทยานแห่งชาติหาดนพรัตน์ธารา":
                temp_sql = " _id >= 40 AND _id <= 42";
                break;
            case "เกาะพีพีเล":
                temp_sql = " _id >= 43 AND _id <= 45";
                break;
            case "เกาะพีพีดอน":
                temp_sql = " _id >= 46 AND _id <= 48";
                break;
            case "เกาะยูง":
                temp_sql = " _id >= 49 AND _id <= 51";
                break;
            case "หาดนุ้ย":
                temp_sql = " _id >= 52 AND _id <= 54";
                break;
            case "อ่าวโละลานะ":
                temp_sql = " _id >= 55 AND _id <= 57";
                break;
            case "เกาะตะเล็งเบ็ง":
                temp_sql = " _id >= 58 AND _id <= 60";
                break;
            case "เกาะห้า":
                temp_sql = " _id >= 61 AND _id <= 63";
                break;
            case "ชุมชนเมืองเก่าลันตา":
                temp_sql = " _id >= 64 AND _id <= 66";
                break;
            case "พิพิธภัณฑ์ชุมชนชาวเกาะลันตา":
                temp_sql = " _id >= 67 AND _id <= 69";
                break;
            case "ศาลาด่าน":
                temp_sql = " _id >= 70 AND _id <= 72";
                break;
            case "หาดคลองโขง":
                temp_sql = " _id >= 73 AND _id <= 75";
                break;
            case "หาดคลองโตบ":
                temp_sql = " _id >= 76 AND _id <= 78";
                break;
            case "หาดคลองจาก":
                temp_sql = " _id >= 79 AND _id <= 81";
                break;
            case "หาดคลองดาว":
                temp_sql = " _id >= 82 AND _id <= 84";
                break;
            case "หาดคลองนิน":
                temp_sql = " _id >= 85 AND _id <= 87";
                break;
            case "หาดคลองหิน":
                temp_sql = " _id >= 88 AND _id <= 90";
                break;
            case "หาดคอกวาง ":
                temp_sql = " _id >= 91 AND _id <= 93";
                break;
            case "หาดบากันเตียง ":
                temp_sql = " _id >= 94 AND _id <= 96";
                break;
            case "หาดพระแอะ":
                temp_sql = " _id >= 97 AND _id <= 99";
                break;
            case "อ่าวไม้ไผ่":
                temp_sql = " _id >= 100 AND _id <= 102";
                break;
            case "อุทยานแห่งชาติหมู่เกาะลันตา":
                temp_sql = " _id >= 103 AND _id <= 105";
                break;
            case "ถ้ำเขาผึ้ง":
                temp_sql = " _id >= 106 AND _id <= 108";
                break;
            case "น้ำตกห้วยโต้":
                temp_sql = " _id >= 109 AND _id <= 111";
                break;
            case "อุทยานแห่งชาติเขาพนมเบญจา":
                temp_sql = " _id >= 112 AND _id <= 114";
                break;
            case "เกาะจำ":
                temp_sql = " _id >= 115 AND _id <= 117";
                break;
            case "หาดถ้ำพระนาง":
                temp_sql = " _id >= 118 AND _id <= 120";
                break;
            case "อ่าวไร่เลย์":
                temp_sql = " _id >= 121 AND _id <= 123";
                break;
            case "น้ำตกร้อนคลองท่อม":
                temp_sql = " _id >= 124 AND _id <= 126";
                break;
            case "น้ำตกหินเพิง":
                temp_sql = " _id >= 127 AND _id <= 129";
                break;
            case "น้ำพุร้อนเค็มคลองท่อม":
                temp_sql = " _id >= 130 AND _id <= 132";
                break;
            case "พิพิธภัณฑสถานวัดคลองท่อมพิพิธภัณฑ์":
                temp_sql = " _id >= 133 AND _id <= 135";
                break;
            case "สระมรกต":
                temp_sql = " _id >= 136 AND _id <= 138";
                break;
            case "เกาะมะพร้าว":
                temp_sql = " _id >= 139 AND _id <= 141";
                break;
            case "เกาะมัตรา":
                temp_sql = " _id >= 142 AND _id <= 144";
                break;
            case "เกาะรังกาจิว":
                temp_sql = " _id >= 145 AND _id <= 147";
                break;
            case "เกาะละวะ":
                temp_sql = " _id >= 148 AND _id <= 150";
                break;
            case "เกาะหลักแรด":
                temp_sql = " _id >= 151 AND _id <= 153";
                break;
            case "จุดชมวิวเขามัทรี":
                temp_sql = " _id >= 154 AND _id <= 156";
                break;
            case "พิพิธภัณฑสถานแห่งชาติ":
                temp_sql = " _id >= 157 AND _id <= 159";
                break;
            case "ศาลกรมหลวงชุมพร":
                temp_sql = " _id >= 160 AND _id <= 162";
                break;
            case "หาดทรายรี":
                temp_sql = " _id >= 163 AND _id <= 165";
                break;
            case "หาดภราดรภาพ":
                temp_sql = " _id >= 166 AND _id <= 168";
                break;
            case "อนุสาวรีย์ยุวชนทหาร":
                temp_sql = " _id >= 169 AND _id <= 171";
                break;
            case "อ่าวทุ่งมะขาม":
                temp_sql = " _id >= 172 AND _id <= 174";
                break;
            case "อุทยานแห่งชาติหมู่เกาะทะเลชุมพร":
                temp_sql = " _id >= 175 AND _id <= 177";
                break;
            case "วนอุทยานน้ำตกกะเปาะ":
                temp_sql = " _id >= 178 AND _id <= 180";
                break;
            case "ศาลพ่อตาหินช้าง":
                temp_sql = " _id >= 181 AND _id <= 183";
                break;
            case "เกาะง่ามใหญ่ และ ง่ามน้อย":
                temp_sql = " _id >= 184 AND _id <= 186";
                break;
            case "หาดทุ่งวัวแล่น":
                temp_sql = " _id >= 187 AND _id <= 189";
                break;
            case "น้ำตกเหวโหลม":
                temp_sql = " _id >= 190 AND _id <= 192";
                break;
            case "บ่อน้ำร้อนถ้ำเขาพลู":
                temp_sql = " _id >= 193 AND _id <= 195";
                break;
            case "หาดตะวันฉาย":
                temp_sql = " _id >= 196 AND _id <= 198";
                break;
            case "หาดทรายรีสวี":
                temp_sql = " _id >= 199 AND _id <= 201";
                break;
            case "เกาะพิทักษ์":
                temp_sql = " _id >= 202 AND _id <= 204";
                break;
            case "ฟาร์มกาแฟขี้ชะมด":
                temp_sql = " _id >= 205 AND _id <= 207";
                break;
            case "สวนนายดำ":
                temp_sql = " _id >= 208 AND _id <= 210";
                break;
            case "สวนสมเด็จพระศรีนครินทร์ฯ":
                temp_sql = " _id >= 211 AND _id <= 213";
                break;
            case "หาดแหลมสน ชุมพร":
                temp_sql = " _id >= 214 AND _id <= 216";
                break;
            case "สระกะพังสุรินทร์":
                temp_sql = " _id >= 217 AND _id <= 219";
                break;
            case "เกาะลิบง":
                temp_sql = " _id >= 220 AND _id <= 222";
                break;
            case "หาดหยงหลิน":
                temp_sql = " _id >= 223 AND _id <= 225";
                break;
            case "ถ้ำเขาช้างหาย":
                temp_sql = " _id >= 226 AND _id <= 228";
                break;
            case "อุทยานนกน้ำคลองลำซาน":
                temp_sql = " _id >= 229 AND _id <= 231";
                break;
            case "เกาะเหลาเหลียง":
                temp_sql = " _id >= 232 AND _id <= 234";
                break;
            case "เกาะสุกร":
                temp_sql = " _id >= 235 AND _id <= 237";
                break;
            case "น้ำตกโตนตก":
                temp_sql = " _id >= 238 AND _id <= 240";
                break;
            case "เกาะเชือก-เกาะแหวน":
                temp_sql = " _id >= 241 AND _id <= 243";
                break;
            case "เกาะไหง":
                temp_sql = " _id >= 244 AND _id <= 246";
                break;
            case "เกาะกระดาน":
                temp_sql = " _id >= 247 AND _id <= 249";
                break;
            case "เกาะมุก ถ้ำมรกต":
                temp_sql = " _id >= 250 AND _id <= 253";
                break;
            case "น้ำตกอ่างทอง":
                temp_sql = " _id >= 254 AND _id <= 256";
                break;
            case "หาดปากเมง":
                temp_sql = " _id >= 257 AND _id <= 259";
                break;
            case "เขาปินะ":
                temp_sql = " _id >= 260 AND _id <= 262";
                break;
            case "บ้านหนังตะลุงสุชาติ ทรัพย์สิน":
                temp_sql = " _id >= 263 AND _id <= 265";
                break;
            case "หาดในเพลา":
                temp_sql = " _id >= 266 AND _id <= 268";
                break;
            case "หาดขนอม":
                temp_sql = " _id >= 269 AND _id <= 271";
                break;
            case "อ่าวขนอม":
                temp_sql = " _id >= 272 AND _id <= 274";
                break;
            case "อ่าวท้องหยี":
                temp_sql = " _id >= 275 AND _id <= 277";
                break;
            case "น้ำตกท่าแพ":
                temp_sql = " _id >= 278 AND _id <= 280";
                break;
            case "หาดสระบัว":
                temp_sql = " _id >= 281 AND _id <= 283";
                break;
            case "อุทยานแห่งชาติเขานัน":
                temp_sql = " _id >= 284 AND _id <= 286";
                break;
            case "ถ้ำตลอด":
                temp_sql = " _id >= 287 AND _id <= 289";
                break;
            case "อุทยานแห่งชาติน้ำตกโยง":
                temp_sql = " _id >= 290 AND _id <= 292";
                break;
            case "น้ำตกกรุงชิง":
                temp_sql = " _id >= 293 AND _id <= 295";
                break;
            case "น้ำตกยอดเหลือง":
                temp_sql = " _id >= 296 AND _id <= 298";
                break;
            case "น้ำตกวังลุง":
                temp_sql = " _id >= 299 AND _id <= 301";
                break;
            case "ล่องแก่งคลองกลาย":
                temp_sql = " _id >= 302 AND _id <= 304";
                break;
            case "น้ำตกคลองจัง":
                temp_sql = " _id >= 305 AND _id <= 307";
                break;
            case "แหลมตะลุมพุก":
                temp_sql = " _id >= 308 AND _id <= 310";
                break;
            case "น้ำตกอ้ายเขียว":
                temp_sql = " _id >= 311 AND _id <= 313";
                break;
            case "วัดเขาขุนพนม":
                temp_sql = " _id >= 314 AND _id <= 316";
                break;
            case "น้ำตกสี่ขีด":
                temp_sql = " _id >= 317 AND _id <= 319";
                break;
            case "หาดคอเขา":
                temp_sql = " _id >= 320 AND _id <= 322";
                break;
            case "หาดสิชล":
                temp_sql = " _id >= 323 AND _id <= 325";
                break;
            case "หาดหินงาม":
                temp_sql = " _id >= 326 AND _id <= 328";
                break;
            case "ชายหาดนราทัศน์":
                temp_sql = " _id >= 329 AND _id <= 331";
                break;
            case "พระตำหนักทักษิณราชนิเวศน์":
                temp_sql = " _id >= 332 AND _id <= 334";
                break;
            case "อ่าวมะนาว":
                temp_sql = " _id >= 335 AND _id <= 337";
                break;
            case "เกาะยาว":
                temp_sql = " _id >= 338 AND _id <= 340";
                break;
            case "น้ำตกซีโป":
                temp_sql = " _id >= 341 AND _id <= 343";
                break;
            case "น้ำตกฉัตรวาริน":
                temp_sql = " _id >= 344 AND _id <= 346";
                break;
            case "ป่าพรุโต๊ะแดง":
                temp_sql = " _id >= 347 AND _id <= 349";
                break;
            case "พิพิธภัณฑ์ศูนย์การศึกษาเกี่ยวกับภาคใต้":
                temp_sql = " _id >= 350 AND _id <= 352";
                break;
            case "ศาลหลักเมืองปัตตานี":
                temp_sql = " _id >= 353 AND _id <= 355";
                break;
            case "ศาลเจ้าแม่ลิ้มกอเหนี่ยว":
                temp_sql = " _id >= 356 AND _id <= 358";
                break;
            case "น้ำตกอรัญวาริน":
                temp_sql = " _id >= 359 AND _id <= 361";
                break;
            case "อุทยานแห่งชาติน้ำตกทรายขาว":
                temp_sql = " _id >= 362 AND _id <= 364";
                break;
            case "หาดแฆแฆ":
                temp_sql = " _id >= 365 AND _id <= 367";
                break;
            case "วังเก่ายะหริ่ง":
                temp_sql = " _id >= 368 AND _id <= 370";
                break;
            case "หาดตะโละกาโปร์":
                temp_sql = " _id >= 371 AND _id <= 373";
                break;
            case "หาดหนองจิก":
                temp_sql = " _id >= 374 AND _id <= 376";
                break;
            case "เกาะไข่":
                temp_sql = " _id >= 377 AND _id <= 379";
                break;
            case "เกาะยาวใหญ่":
                temp_sql = " _id >= 380 AND _id <= 382";
                break;
            case "เกาะยาวน้อย":
                temp_sql = " _id >= 383 AND _id <= 385";
                break;
            case "หาดโละปาแรด":
                temp_sql = " _id >= 386 AND _id <= 388";
                break;
            case "หาดท่าเขา":
                temp_sql = " _id >= 389 AND _id <= 391";
                break;
            case "หาดป่าทราย":
                temp_sql = " _id >= 392 AND _id <= 394";
                break;
            case "เขาช้าง":
                temp_sql = " _id >= 395 AND _id <= 397";
                break;
            case "ถ้ำเขางุ้ม":
                temp_sql = " _id >= 398 AND _id <= 400";
                break;
            case "ถ้ำพุงช้าง":
                temp_sql = " _id >= 401 AND _id <= 403";
                break;
            case "ถ้ำฤาษีสวรรค์":
                temp_sql = " _id >= 404 AND _id <= 406";
                break;
            case "อุทยานแห่งชาติอ่าวพังงา":
                temp_sql = " _id >= 407 AND _id <= 409";
                break;
            case "เกาะตาชัย":
                temp_sql = " _id >= 410 AND _id <= 412";
                break;
            case "อุทยานแห่งชาติหมู่เกาะสิมิลัน":
                temp_sql = " _id >= 413 AND _id <= 415";
                break;
            case "ชายทะเลท่านุ่น":
                temp_sql = " _id >= 416 AND _id <= 418";
                break;
            case "น้ำตกรามัญ":
                temp_sql = " _id >= 419 AND _id <= 421";
                break;
            case "วัดสุวรรณคูหา":
                temp_sql = " _id >= 422 AND _id <= 424";
                break;
            case "น้ำตกลำรู่":
                temp_sql = " _id >= 425 AND _id <= 427";
                break;
            case "น้ำตกหินลาด":
                temp_sql = " _id >= 428 AND _id <= 430";
                break;
            case "หาดนางทอง":
                temp_sql = " _id >= 431 AND _id <= 433";
                break;
            case "หาดบางเนียง":
                temp_sql = " _id >= 434 AND _id <= 436";
                break;
            case "หาดบางสัก":
                temp_sql = " _id >= 437 AND _id <= 439";
                break;
            case "หาดปากวีป":
                temp_sql = " _id >= 440 AND _id <= 442";
                break;
            case "อุทยานแห่งชาติเขาหลัก":
                temp_sql = " _id >= 443 AND _id <= 445";
                break;
            case "ศูนย์อนุรักษ์กลางโครงการ อุทยานใต้ทะเลจุฬาภรณ์":
                temp_sql = " _id >= 446 AND _id <= 448";
                break;
            case "อุทยานแห่งชาติเขาลำปี":
                temp_sql = " _id >= 449 AND _id <= 451";
                break;
            case "บ่อน้ำร้อนธารน้ำเย็น":
                temp_sql = " _id >= 452 AND _id <= 454";
                break;
            case "ถ้ำคูหาสวรรค์":
                temp_sql = " _id >= 455 AND _id <= 457";
                break;
            case "ถ้ำมาลัย":
                temp_sql = " _id >= 458 AND _id <= 460";
                break;
            case "น้ำตกเขาคราม":
                temp_sql = " _id >= 461 AND _id <= 463";
                break;
            case "น้ำตกบ้านโตน":
                temp_sql = " _id >= 464 AND _id <= 466";
                break;
            case "ภูเขาอกทะลุ":
                temp_sql = " _id >= 467 AND _id <= 469";
                break;
            case "วังเจ้าเมืองพัทลุง":
                temp_sql = " _id >= 470 AND _id <= 472";
                break;
            case "หาดแสนสุขลำปำ":
                temp_sql = " _id >= 473 AND _id <= 475";
                break;
            case "เกาะเฮ":
                temp_sql = " _id >= 476 AND _id <= 478";
                break;
            case "เกาะแก้ว":
                temp_sql = " _id >= 479 AND _id <= 481";
                break;
            case "เกาะไม้ท่อน":
                temp_sql = " _id >= 482 AND _id <= 484";
                break;
            case "เกาะมะพร้าวภูเก็ต":
                temp_sql = " _id >= 485 AND _id <= 487";
                break;
            case "เกาะราชาใหญ่":
                temp_sql = " _id >= 488 AND _id <= 490";
                break;
            case "แหลมพรหมเทพ":
                temp_sql = " _id >= 491 AND _id <= 493";
                break;
            case "ตึกสมัยเก่า":
                temp_sql = " _id >= 494 AND _id <= 496";
                break;
            case "บ้านตีลังกา":
                temp_sql = " _id >= 497 AND _id <= 499";
                break;
            case "พิพิธภัณฑ์ภูเก็ตไทยหัว":
                temp_sql = " _id >= 500 AND _id <= 502";
                break;
            case "พุทธอุทยานภูเก็ต":
                temp_sql = " _id >= 503 AND _id <= 505";
                break;
            case "ฟาร์มชนะเจริญ":
                temp_sql = " _id >= 506 AND _id <= 508";
                break;
            case "วัดไชยธาราราม":
                temp_sql = " _id >= 509 AND _id <= 511";
                break;
            case "สถานแสดงพันธุ์สัตว์น้ำ":
                temp_sql = " _id >= 512 AND _id <= 514";
                break;
            case "สยามนิรมิตภูเก็ต":
                temp_sql = " _id >= 515 AND _id <= 517";
                break;
            case "สวนนก":
                temp_sql = " _id >= 518 AND _id <= 520";
                break;
            case "อควาเรียมภูเก็ต":
                temp_sql = " _id >= 521 AND _id <= 523";
                break;
            case "สะพานหิน":
                temp_sql = " _id >= 524 AND _id <= 526";
                break;
            case "หอชมวิวเขาขาด":
                temp_sql = " _id >= 527 AND _id <= 529";
                break;
            case "หาดในหาน":
                temp_sql = " _id >= 530 AND _id <= 532";
                break;
            case "หาดกะรน":
                temp_sql = " _id >= 533 AND _id <= 535";
                break;
            case "หาดยะนุ้ย":
                temp_sql = " _id >= 536 AND _id <= 538";
                break;
            case "หาดราไวย์":
                temp_sql = " _id >= 539 AND _id <= 541";
                break;
            case "แหลมสิงห์":
                temp_sql = " _id >= 542 AND _id <= 544";
                break;
            case "ถนนบางลา":
                temp_sql = " _id >= 545 AND _id <= 547";
                break;
            case "ภูเก็ตแฟนตาซี":
                temp_sql = " _id >= 548 AND _id <= 550";
                break;
            case "สะพานสารสิน":
                temp_sql = " _id >= 551 AND _id <= 553";
                break;
            case "หาดป่าตอง":
                temp_sql = " _id >= 554 AND _id <= 556";
                break;
            case "หาดสุรินทร์":
                temp_sql = " _id >= 557 AND _id <= 559";
                break;
            case "สวนน้ำสแปลชจังเกิ้ล":
                temp_sql = " _id >= 560 AND _id <= 562";
                break;
            case "หาดไม้ขาว":
                temp_sql = " _id >= 563 AND _id <= 565";
                break;
            case "หาดบางเทา":
                temp_sql = " _id >= 566 AND _id <= 568";
                break;
            case "อนุสาวรีย์ท้ายเทพกษัตรีย์และท้าวศรีสุนทร":
                temp_sql = " _id >= 569 AND _id <= 571";
                break;
            case "อุทยานแห่งชาติสิรินาถ":
                temp_sql = " _id >= 572 AND _id <= 574";
                break;
            case "บ่อน้ำร้อนเบตง":
                temp_sql = " _id >= 575 AND _id <= 577";
                break;
            case "พระมหาธาตุเจดีย์พระพุทธธรรมประกาศ":
                temp_sql = " _id >= 578 AND _id <= 580";
                break;
            case "สวนไม้ดอกเมืองหนาว":
                temp_sql = " _id >= 581 AND _id <= 583";
                break;
            case "อุโมงค์ปิยะมิตร":
                temp_sql = " _id >= 584 AND _id <= 586";
                break;
            case "ถ้ำสำเภาทอง":
                temp_sql = " _id >= 587 AND _id <= 589";
                break;
            case "ศาลเจ้าพ่อหลักเมือง":
                temp_sql = " _id >= 590 AND _id <= 592";
                break;
            case "วนอุทยานน้ำตกธารโต":
                temp_sql = " _id >= 593 AND _id <= 595";
                break;
            case "ถ้ำกระแซง":
                temp_sql = " _id >= 596 AND _id <= 598";
                break;
            case "เกาะช้าง":
                temp_sql = " _id >= 599 AND _id <= 601";
                break;
            case "เกาะพยาม":
                temp_sql = " _id >= 602 AND _id <= 604";
                break;
            case "น้ำพุร้อนพรรั้ง":
                temp_sql = " _id >= 605 AND _id <= 607";
                break;
            case "บ่อน้ำร้อนพรุลุมพี":
                temp_sql = " _id >= 608 AND _id <= 610";
                break;
            case "เขาหัวล้าน":
                temp_sql = " _id >= 611 AND _id <= 613";
                break;
            case "หาดชาญดำริ":
                temp_sql = " _id >= 614 AND _id <= 616";
                break;
            case "อ่าวใหญ่":
                temp_sql = " _id >= 617 AND _id <= 619";
                break;
            case "คอคอดกระ":
                temp_sql = " _id >= 620 AND _id <= 622";
                break;
            case "ถ้ำพระขยางค์":
                temp_sql = " _id >= 623 AND _id <= 625";
                break;
            case "น้ำตกบกกราย":
                temp_sql = " _id >= 626 AND _id <= 628";
                break;
            case "เกาะกำใหญ่":
                temp_sql = " _id >= 629 AND _id <= 631";
                break;
            case "เกาะกำตก":
                temp_sql = " _id >= 632 AND _id <= 634";
                break;
            case "เกาะค้างคาว":
                temp_sql = " _id >= 635 AND _id <= 637";
                break;
            case "หาดบางเบน":
                temp_sql = " _id >= 638 AND _id <= 640";
                break;
            case "หาดประพาส":
                temp_sql = " _id >= 641 AND _id <= 643";
                break;
            case "เขาฝาชี":
                temp_sql = " _id >= 644 AND _id <= 646";
                break;
            case "หาดสะกอม":
                temp_sql = " _id >= 647 AND _id <= 649";
                break;
            case "เกาะยอ":
                temp_sql = " _id >= 650 AND _id <= 652";
                break;
            case "เกาะหนู":
                temp_sql = " _id >= 653 AND _id <= 655";
                break;
            case "แหลมสนอ่อน":
                temp_sql = " _id >= 656 AND _id <= 658";
                break;
            case "แหลมสมิหลา":
                temp_sql = " _id >= 659 AND _id <= 661";
                break;
            case "ทะเลสาบสงขลา":
                temp_sql = " _id >= 662 AND _id <= 664";
                break;
            case "สวนสัตว์สงขลา":
                temp_sql = " _id >= 665 AND _id <= 667";
                break;
            case "หาดทรายแก้ว":
                temp_sql = " _id >= 668 AND _id <= 670";
                break;
            case "หาดสร้อยสวรรค์":
                temp_sql = " _id >= 671 AND _id <= 673";
                break;
            case "อุทยานแห่งชาติเขาน้ำค้าง":
                temp_sql = " _id >= 674 AND _id <= 676";
                break;
            case "หาดสทิงพระ":
                temp_sql = " _id >= 677 AND _id <= 679";
                break;
            case "อุทยานนกน้ำคูขุด":
                temp_sql = " _id >= 680 AND _id <= 682";
                break;
            case "น้ำตกโตนงาช้าง":
                temp_sql = " _id >= 683 AND _id <= 685";
                break;
            case "สวนสาธารณะเทศบาลเมืองหาดใหญ่":
                temp_sql = " _id >= 686 AND _id <= 688";
                break;
            case "แหลมตันหยงโป":
                temp_sql = " _id >= 689 AND _id <= 691";
                break;
            case "คฤหาสน์กูเด็น":
                temp_sql = " _id >= 692 AND _id <= 694";
                break;
            case "สวนสาธารณะเขาพญาวัง":
                temp_sql = " _id >= 695 AND _id <= 697";
                break;
            case "อ่าวพันเตมะละกา":
                temp_sql = " _id >= 698 AND _id <= 700";
                break;
            case "อุทยานแห่งชาติทะเลบัน":
                temp_sql = " _id >= 701 AND _id <= 702";
                break;
            case "น้ำตกธาราสวรรค์":
                temp_sql = " _id >= 703 AND _id <= 705";
                break;
            case "ถ้ำเขาทะนาน":
                temp_sql = " _id >= 706 AND _id <= 708";
                break;
            case "น้ำตกธารปลิว":
                temp_sql = " _id >= 709 AND _id <= 711";
                break;
            case "หาดราไวย์สตูล":
                temp_sql = " _id >= 712 AND _id <= 714";
                break;
            case "ถ้ำภูผาเพชร":
                temp_sql = " _id >= 715 AND _id <= 117";
                break;
            case "น้ำตกวังสายทอง":
                temp_sql = " _id >= 718 AND _id <= 720";
                break;
            case "เกาะบุโหลน":
                temp_sql = " _id >= 721 AND _id <= 723";
                break;
            case "เกาะลิดี":
                temp_sql = " _id >= 724 AND _id <= 726";
                break;
            case "ถนนคนเดิน เกาะหลีเป๊ะ":
                temp_sql = " _id >= 727 AND _id <= 729";
                break;
            case "ร่องน้ำอาบัง":
                temp_sql = " _id >= 730 AND _id <= 732";
                break;
            case "หาดซันเซ็ท":
                temp_sql = " _id >= 733 AND _id <= 735";
                break;
            case "หาดซันไรซ์":
                temp_sql = " _id >= 736 AND _id <= 738";
                break;
            case "เกาะตะรุเตา":
                temp_sql = " _id >= 739 AND _id <= 741";
                break;
            case "เกาะหลีเป๊ะ":
                temp_sql = " _id >= 742 AND _id <= 744";
                break;
            case "เกาะหินงาม":
                temp_sql = " _id >= 745 AND _id <= 747";
                break;
            case "หมู่เกาะอาดัง-ราวี":
                temp_sql = " _id >= 748 AND _id <= 750";
                break;
            case "เกาะเต่า":
                temp_sql = " _id >= 751 AND _id <= 753";
                break;
            case "เกาะนางยวน":
                temp_sql = " _id >= 754 AND _id <= 756";
                break;
            case "แหล่งดำน้ำเกาะเต่า":
                temp_sql = " _id >= 757 AND _id <= 759";
                break;
            case "อุทยานแห่งชาติน้ำตกธารเสด็จ":
                temp_sql = " _id >= 760 AND _id <= 762";
                break;
            case "หาดแม่หาด":
                temp_sql = " _id >= 763 AND _id <= 765";
                break;
            case "หาดริ้น":
                temp_sql = " _id >= 766 AND _id <= 768";
                break;
            case "อ่าวโตนด":
                temp_sql = " _id >= 769 AND _id <= 771";
                break;
            case "เกาะแตน":
                temp_sql = " _id >= 772 AND _id <= 774";
                break;
            case "เกาะวัวตาหลับ":
                temp_sql = " _id >= 775 AND _id <= 777";
                break;
            case "ทะเลใน":
                temp_sql = " _id >= 778 AND _id <= 780";
                break;
            case "น้ำตกหน้าเหมือง":
                temp_sql = " _id >= 781 AND _id <= 783";
                break;
            case "พระธาตุหินงู":
                temp_sql = " _id >= 784 AND _id <= 786";
                break;
            case "สวนผีเสื้อสมุย":
                temp_sql = " _id >= 787 AND _id <= 789";
                break;
            case "หาดเฉวง":
                temp_sql = " _id >= 790 AND _id <= 792";
                break;
            case "หาดแม่น้ำ":
                temp_sql = " _id >= 793 AND _id <= 795";
                break;
            case "หาดบ่อผุด":
                temp_sql = " _id >= 796 AND _id <= 798";
                break;
            case "หินตา หินยาย":
                temp_sql = " _id >= 799 AND _id <= 801";
                break;
            case "คลองร้อยสาย":
                temp_sql = " _id >= 802 AND _id <= 804";
                break;
            case "ศาลหลักเมืองสุราษฎร์ธานี":
                temp_sql = " _id >= 805 AND _id <= 807";
                break;
            case "พิพิธภัณฑสถานแห่งชาติไชยา":
                temp_sql = " _id >= 808 AND _id <= 810";
                break;
            case "วัดหลง":
                temp_sql = " _id >= 811 AND _id <= 813";
                break;
            case "ฟาร์มหอยนางรม":
                temp_sql = " _id >= 814 AND _id <= 816";
                break;
            case "บ่อน้ำร้อน":
                temp_sql = " _id >= 817 AND _id <= 819";
                break;
            case "ถ้ำสิงขร":
                temp_sql = " _id >= 820 AND _id <= 822";
                break;
            case "น้ำตกวิภาวดี":
                temp_sql = " _id >= 823 AND _id <= 825";
                break;
            case "วังหิน":
                temp_sql = " _id >= 826 AND _id <= 828";
                break;
            case "เขื่อนรัชประภา":
                temp_sql = " _id >= 829 AND _id <= 831";
                break;
            case "บ่อน้ำพุร้อนท่าสะท้อน":
                temp_sql = " _id >= 832 AND _id <= 834";
                break;
            case "วัดเขาศรีวิชัย":
                temp_sql = " _id >= 835 AND _id <= 837";
                break;
            case "หาดแหลมสน":
                temp_sql = " _id >= 838 AND _id <= 840";
                break;
            case "อุทยานแห่งชาติเขาลำปี พังงา":
                temp_sql = " _id >= 841 AND _id <= 843";
                break;
            case "เกาะมุก":
                temp_sql = " _id >= 844 AND _id <= 846";
                break;

            // สถานที่ท่อเงที่ยวที่น่าสนใจ
            case "เกาะไข่นอก":
                temp_sql = " _id >= 844 AND _id <= 846";
                break;
            case "เกาะลันตา":
                temp_sql = " _id >= 844 AND _id <= 846";
                break;

            //ฤดู
            case "หมู่เกาะสิมิลัน":
                temp_sql = " _id >= 844 AND _id <= 846";
                break;
            case "อุทยานแห่งชาติตะรุเตา":
                temp_sql = " _id >= 844 AND _id <= 846";
                break;
            case "น้ำตกพะโต๊ะ":
                temp_sql = " _id >= 844 AND _id <= 846";
                break;
            case "หาดสมิหลา":
                temp_sql = " _id >= 844 AND _id <= 846";
                break;
            case "เกาะราวี":
                temp_sql = " _id >= 844 AND _id <= 846";
                break;
        }

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM restaurant WHERE" + temp_sql, null);
        cursor.moveToFirst();

        restaurantname = new String[cursor.getCount()];
        restaurantimge = new String[cursor.getCount()];
        restaurantimgeB = new String[cursor.getCount()];
        restaurantimgeC = new String[cursor.getCount()];
        restaurantdescription = new String[cursor.getCount()];
        restaurantopen = new String[cursor.getCount()];
        restaurantaddress = new String[cursor.getCount()];
        restauranttravel = new String[cursor.getCount()];
        restaurantprice = new String[cursor.getCount()];
        resurl = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++) {

            restaurantname[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantname));
            restaurantimge[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimge));
            restaurantimgeB[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimgeB));
            restaurantimgeC[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimgeC));
            restaurantdescription[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantdescription));
            restaurantopen[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantopen));
            restaurantaddress[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantaddress));
            restauranttravel[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restauranttravel));
            restaurantprice[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantprice));
            resurl[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_resurl));
            cursor.moveToNext();
        }
        cursor.close();

        MyAdpter myAdapter = new MyAdpter(this, restaurantname);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RestaurantActivityManu.this, RestaurantActivity.class);

                intent.putExtra("restaurant1", restaurantname[i]);
                intent.putExtra("restaurant2", restaurantimge[i]);
                intent.putExtra("restaurant3", restaurantimgeB[i]);
                intent.putExtra("restaurant4", restaurantimgeC[i]);
                intent.putExtra("restaurant5", restaurantdescription[i]);
                intent.putExtra("restaurant6", restaurantopen[i]);
                intent.putExtra("restaurant7", restaurantaddress[i]);
                intent.putExtra("restaurant8", restauranttravel[i]);
                intent.putExtra("restaurant9", restaurantprice[i]);
                intent.putExtra("restaurant10", resurl[i]);
                startActivity(intent);
            }//onItem
        });
    }
}

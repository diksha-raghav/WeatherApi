

var formNameList = [[101,"Bank/CSC Visit"],[102,"Crop Health Monitoring"],[103,"Supervision of Loss Assessment Surveys"],[104,"CCE Supervision"],[105,"General Investigation"],[106,"Publicity Materials or Other Modes"],[107,"Meetings Attended/ Organised"],[108,"Awareness and Publicity Campaign"],[109,"Field Visit"],[110,"Office Visit"],[111,"Area Sown Report"],[112,"Weather Report"],[113,"Weather Station Inspection"],[114,"Media Reports/Publications"],[115,"Insured Crop Verification"]];
var htmlString = "<option value='select'>--Select--</option><option value='100'> ALL </option>";
/*
 * var actual = ["SUBDIVISION : A & N ISLAND", "NICOBAR", "NORTH & MIDDLE
 * ANDAMAN", "SOUTH ANDAMAN", "SUBDIVISION : ARUNACHAL PRADESH", "ANJAW",
 * "CHANGLANG", "DIBANG VALLEY", "EAST KAMENG", "EAST SIANG", "KURUNG KUMEY",
 * "LOHIT", "LOWER DIBANG VALLEY", "LOWER SUBANSIRI", "PAPUM-PARE", "TAWANG",
 * "TIRAP", "UPPER SIANG", "UPPER SUBANSIRI", "WEST KAMENG", "WEST SIANG",
 * "SUBDIVISION : ASSAM & MEGHALAYA", "STATE : ASSAM", "BAKSA", "BARPETA",
 * "BONGAIGAON", "CACHAR", "CHIRANG", "DARRANG", "DHEMAJI", "DHUBRI",
 * "DIBRUGARH", "GOALPARA", "GOLAGHAT", "HAILAKANDI", "JORHAT", "KAMRUP METRO",
 * "KAMRUP RURAL", "KARBI ANALOG", "KARIMGANJ", "KOKRAJHAR", "LAKHIMPUR",
 * "MORIGAON", "N.C HILLS", "NAGAON", "NALBARI", "SIBSAGAR", "SONITPUR",
 * "TINSUKIA", "UDALGURI", "STATE : MEGHALAYA", "EAST GARO HILLS", "EAST KHASI
 * HILLS", "JAINTIA HILLS", "RI BHOI", "SOUTH GARO HILLS", "WEST GARO HILLS",
 * "WEST KHASI HILLS", "SUBDIVISION : N M M T", "STATE : NAGALAND", "DIMAPUR",
 * "KIPHIRE", "KOHIMA", "LONGLENG", "MOKOKCHUNG", "MON", "PEREN", "PHEK",
 * "TUENSANG", "WOKHA", "ZUNHEBOTO", "STATE : MANIPUR", "BISHNUPUR", "CHANDEL",
 * "CHURACHANDPUR", "IMPHAL EAST", "IMPHAL WEST", "SENAPATI", "TAMENGLONG",
 * "THOUBAL", "UKHRUL", "STATE : MIZORAM", "AIZAWL", "CHAMPHAI", "KOLASIB",
 * "LAWNGTLAI", "LUNGLEI", "MAMIT", "SAIHA", "SERCHHIP", "STATE : TRIPURA",
 * "DHALAI", "NORTH TRIPURA", "SOUTH TRIPURA", "WEST TRIPURA", "SUBDIVISION :
 * SHWB & SIKKIM", "STATE : SIKKIM", "EAST SIKKIM", "NORTH SIKKIM", "SOUTH
 * SIKKIM", "WEST SIKKIM", "STATE : WEST BENGAL", "DAKSHIN DINAJPUR",
 * "DARJEELING", "JALPAIGURI", "KOCHBIHAR", "MALDA", "UTTAR_DINAJPUR",
 * "SUBDIVISION : GANGETIC WEST BENGAL", "BANKURA", "BARDAMAN", "BIRBHUM",
 * "EASTMEDNIPUR", "HAORA", "HUGLI", "KOLKATA", "MURSIDABAD", "NADIA", "NORTH 24
 * PRAGANA", "PASHCHIM MEDINIPUR", "PURULIYA", "SOUTH 24 PARGANAS", "SUBDIVISION :
 * ODISHA", "ANUGUL", "BALANGIR", "BALESHWAR", "BARAGARH", "BAUDA", "BHADRAK",
 * "CUTTACK", "DEOGARH", "DHENKANAL", "GAJAPATHI", "GANJAM", "JAGATSINGHAPUR",
 * "JAJAPUR", "JHARSUGUDA", "KALAHANDI", "KANDHAMAL", "KENDRAPARHA",
 * "KENDUJHAR", "KHORDHA", "KORAPUT", "MALKANGIRI", "MAYURBHANJ",
 * "NABARANGAPUR", "NAYAGARH", "NUAPARHA", "PURI", "RAYAGARHA", "SAMBALPUR",
 * "SUBARNAPUR", "SUNDARGARH", "SUBDIVISION : JHARKHAND", "BOKARO", "CHATRA",
 * "DEOGHAR", "DHANBAD", "DUMKA", "EAST SINGHBHUM", "GARHWA", "GIRIDIH",
 * "GODDA", "GUMLA", "HAZARIBAGH", "JAMTARA", "KHUNTI", "KODERMA", "LATEHAR",
 * "LOHARDAGA", "PAKUR", "PALAMU", "RAMGARH", "RANCHI", "SAHEBGANJ",
 * "SARAIKELA", "SIMDEGA", "WEST SINGHBHUM", "SUBDIVISION : BIHAR", "ARARIYA",
 * "ARWAL", "AURANGABAD", "BANKA", "BEGUSARAI", "BHABUA", "BHAGALPUR",
 * "BHOJPUR", "BUXAR", "DRABHANGA", "GAYA", "GOPALGANJ", "JAHANABAD", "JAMUI",
 * "KATIHAR", "KHAGARIA", "KISHANGANJ", "LAKHISARAI", "MADHEPURA", "MADUBANI",
 * "MUNGER", "MUZAFFARPUR", "NALANDA", "NAWADA", "PACHIM CHAMPARAN", "PATNA",
 * "PURBA CHAMPARAN", "PURNIA", "ROHTAS", "SAHARSA", "SAMASTIPUR", "SARAN",
 * "SHEIKHPURA", "SHEOHAR", "SITAMARHI", "SIWAN", "SUPAUL", "VAISHALI",
 * "SUBDIVISION : EAST UTTAR PRADESH", "STATE : UTTAR PRADESH", "ALLAHABAD",
 * "AMBEDKARNAGAR", "AMETHI", "AZAMGARH", "BAHRAICH", "BALLIA", "BALRAMPUR",
 * "BANDA", "BARABANKI", "BASTI", "CHANDAULI", "CHITRAKOOT", "DEORIA",
 * "FAIZABAD", "FARRUKHABAD", "FATEHPUR", "GAZIPUR", "GONDA", "GORAKHPUR",
 * "HARDOI", "JAUNPUR", "KANNAUJ", "KANPUR", "KANPUR DEHAT", "KAUSHAMBI",
 * "KHERI", "KUSHINAGAR", "LUCKNOW", "MAHARAJGANJ", "MAU", "MIRZAPUR",
 * "PRATAPGARH", "RAIBEARELI", "SANTKABIRNAGAR", "SANTRAVIDASNAGAR",
 * "SHRAWASTI", "SIDDHARTHNAGAR", "SITAPUR", "SONBHADRA", "SULTANPUR", "UNNAO",
 * "VARANASI", "SUBDIVISION : WEST UTTAR PRADESH", "AGRA", "ALIGARH", "AURAIYA",
 * "BADAUN", "BAGHPAT", "BAREILLY", "BIJNOR", "BULANDSAHAR", "ETAH", "ETAWAH",
 * "FIROZABAD", "GAUTAMBUDHNAGAR", "GHAZIABAD", "HAMIRPUR", "HAPUR", "JALAUN",
 * "JHANSI", "JYOTIBAPHULE NAGAR", "KANSHIRAMNAGAR", "LALITPUR",
 * "MAHAMAYANAGAR", "MAHOBA", "MAINPURI", "MATHURA", "MEERUT", "MORADABAD",
 * "MUZAFARNAGAR", "PILHIBHIT", "RAMPUR", "SAMBHAL", "SHAHJAHANPUR", "SHAMLI",
 * "SHARANPUR", "SUBDIVISION : UTTARAKHAND", "ALMORA", "BAGESHWAR", "CHAMOLI",
 * "CHAMPAWAT", "DEHRADUN", "HARIDWAR", "NANITAL", "PAURI GARHWAL",
 * "PITHORAGARH", "RUDRAPRAYAG", "TEHRI GARWAL", "UDHAM SINGH NAGAR",
 * "UTTARKASHI", "SUBDIVISION : HAR. CHD & DELHI", "STATE : HARYANA", "AMBALA",
 * "BHIWANI", "FARIDABAD", "FATEHABAD", "GURGAON", "HISAR", "JHAJJAR", "JIND",
 * "KAITHAL", "KARNAL", "KURUKSHETRA", "MAHENDRAGARH", "MEWAT", "PALWAL",
 * "PANCHKULA", "PANIPAT", "REWARI", "ROHTAK", "SIRSA", "SONIPAT",
 * "YAMUNANAGAR", "STATE : CHANDIGARH (UT)", "CHANDIGARH", "STATE : DELHI (UT)",
 * "CENTRAL DELHI", "EAST DELHI", "NEW DELHI", "NORTH DELHI", "NORTH EAST
 * DELHI", "NORTH WEST DELHI", "SOUTH DELHI", "SOUTH WEST DELHI", "WEST DELHI",
 * "SUBDIVISION : PUNJAB", "AMRITSAR", "BARNALA", "BATHINDA", "FARIDKOT",
 * "FATEHGARH SAHIB", "FIROZPUR", "GURDASPUR", "HOSHIARPUR", "JALANDHAR",
 * "KAPURTHALA", "LUDHIANA", "MANSA", "MOGA", "MUKTSAR", "NAWASHAHR", "PATIALA",
 * "RUPNAGAR", "SANGRUR", "SAS NAGAR", "TARN TARAN", "SUBDIVISION : HIMACHAL
 * PRADESH", "BILASPUR", "CHAMBA", "KANGRA", "KINNAUR", "KULLU", "LAHUL&SPITI",
 * "MANDI", "SHIMLA", "SIRMAUR", "SOLAN", "UNA", "SUBDIVISION : JAMMU & KASHMIR
 * AND LADAKH", "STATE : JAMMU & KASHMIR (UT)", "ANANTNAG", "BADGAM",
 * "BANDIPORE", "BARAMULA", "DODA", "GANDERWAL", "JAMMU", "KATHUA", "KISTWAR",
 * "KULGAM", "KUPWARA", "PULWAMA", "PUNCH", "RAJOURI", "RAMBAN", "RIASI",
 * "SAMBA", "SHOPIAN", "SRINAGAR", "UDHAMPUR", "STATE : LADAKH (UT)", "KARGIL",
 * "LEH AND LADAKH", "SUBDIVISION : WEST RAJASTHAN", "STATE : RAJASTHAN",
 * "BARMER", "BIKANER", "CHURU", "GANGANAGAR", "HANUMANGARH", "JAISELMER",
 * "JALOR", "JODHPUR", "NAGAUR", "PALI", "SUBDIVISION : EAST RAJASTHAN",
 * "AJMER", "ALWAR", "BANSWARA", "BARAN", "BHARATPUR", "BHILWARA", "BUNDI",
 * "CHITTAURGARH", "DAUSA", "DHOLPUR", "DUNGARPUR", "JAIPUR", "JHALAWAR",
 * "JHUNJHUNUN", "KARAULI", "KOTA", "RAJSMAND", "SIKAR", "SIROHI",
 * "SWAIMADHOPUR", "TONK", "UDAIPUR", "SUBDIVISION : WEST MADHYA PRADESH",
 * "STATE : MADHYA PRADESH", "AGAR-MALWA", "ALIRAJPUR", "ASHOKNAGAR", "BARWANI",
 * "BETUL", "BHIND", "BHOPAL", "BURHANPUR", "DATIA", "DEWAS", "DHAR", "GUNA",
 * "GWALIOR", "HARDA", "HOSHANGABAD", "INDORE", "JHABUA", "KHANDWA", "KHARGONE",
 * "MANDSAUR", "MORENA", "NIMACH", "RAISEN", "RAJGARH", "RATLAM", "SEHORE",
 * "SHAJAPUR", "SHEOPUR", "SHIVPURI", "UJJAIN", "VIDESHA", "SUBDIVISION : EAST
 * MADHYA PRADESH", "ANUPPUR", "BALAGHAT", "CHHATARPUR", "CHHINDWARA", "DAMOH",
 * "DINDORI", "JABALPUR", "KATNI", "MANDLA", "NARSHIMAPURA", "PANNA", "REWA",
 * "SAGAR", "SATNA", "SEONI", "SHAHDOL", "SIDHI", "SINGRAULI", "TIKAMGARH",
 * "UMARIA", "SUBDIVISION : GUJARAT REGION", "DAMAN", "STATE : GUJARAT",
 * "AHMADABAD", "ANAND", "ARAVALLI", "BANASKANTHA", "BHARUCH", "CHHOTA UDEPUR",
 * "DAHOD", "DANGS", "GANDHINAGAR", "KHERA", "MAHESANA", "MAHISAGAR", "NARMADA",
 * "NAVSARI", "PANCHMAHAL", "PATAN", "SABAR KANTHA", "SURAT", "TAPI",
 * "VADODARA", "VALSAD", "STATE : DADAR & NAGAR HAVELI (UT)", "DADAR & NAGAR
 * HAVELI", "SUBDIVISION : SAURASHTRA & KUTCH", "AMRELI", "BHAVNAGAR", "BOTAD",
 * "DEVBHOOMI DWARKA", "GIR SOMNATH", "JAMNAGAR", "JUNAGARH", "KACHCHH",
 * "MORBI", "PORBANDAR", "RAJKOT", "SURENDRANAGAR", "DIU", "STATE : DAMAN & DIU
 * (UT)", "SUBDIVISION : KONKAN & GOA", "STATE : GOA", "NORTH GOA", "SOUTH GOA",
 * "STATE : MAHARASHTRA", "MUMBAI CITY", "PALGHAR", "RAIGARH", "RATNAGIRI",
 * "SINDHUDURG", "SUBURBAN MUMBAI", "THANE", "SUBDIVISION : MADHYA MAHARASHTRA",
 * "AHMADNAGAR", "DHULE", "JALGAON", "KOLHAPUR", "NANDURBAR", "NASIK", "PUNE",
 * "SANGLI", "SATARA", "SOLAPUR", "SUBDIVISION : MARATHWADA", "BID", "HINGOLI",
 * "JALNA", "LATUR", "NANDED", "OSMANABAD", "PARBHANI", "SUBDIVISION :
 * VIDARBHA", "AKOLA", "AMARAVATI", "BHANDARA", "BULDHANA", "CHANDRAPUR",
 * "GADCHIROLI", "GONDIYA", "NAGPUR", "WARDHA", "WASHIM", "YAVATMAL",
 * "SUBDIVISION : CHHATTISGARH", "BALARAMPUR", "BALOD", "BALODA BAZAR",
 * "BASTAR", "BEMETARA", "BIJAPUR", "DANTEWARA", "DHAMTARI", "DURG",
 * "GARIABAND", "JANJGIR_CHAMPA", "JASHPUR", "KABIRDHAM", "KANKER", "KONDAGAON",
 * "KORBA", "KOREA", "MAHASAMUND", "MUNGELI", "NARAYANPUR", "RAIPUR",
 * "RAJNANDGAON", "SUKMA", "SURAJPUR", "SURGUJA", "SUBDIVISION : COASTAL AP and
 * YANAM", "YANAM", "STATE : ANDHRA PRADESH", "EAST GODAVARI", "GUNTUR",
 * "KRISHNA", "NELLORE", "PRAKASAM", "SRIKAKULAM", "VISHAKHAPATNAM",
 * "VIZIANAGARAM", "WEST GODAVARI", "SUBDIVISION : TELANGANA", "ADILABAD", "B.
 * KOTHAGUDEM", "HYDERABAD", "J. BHUPALPALLY", "JAGTIAL", "JANGAON", "JOGULAMBA
 * GADWAL", "KAMAREDDY", "KARIMNAGAR", "KHAMMAM", "KUMARAM BHEEM", "M.
 * MALKAJGIRI", "MAHABUBABAD", "MAHABUBNAGAR", "MANCHERIAL", "MEDAK", "MULUGU",
 * "NAGARKURNOOL", "NALGONDA", "NARAYANPET", "NIRMAL", "NIZAMABAD",
 * "PEDDAPALLE", "RAJANNA SIRCILLA", "RANGAREDDY", "SANGAREDDY", "SIDDIPET",
 * "SURYAPET", "VIKARABAD", "WANAPARTHY", "WARANGAL_RURAL", "WARANGAL_URBAN",
 * "Y. BHUVANAGIRI", "SUBDIVISION : RAYALASEEMA", "ANANTHAPUR", "CHITTOOR",
 * "CUDDAPAH", "KURNOOL", "SUBDIVISION : TN PUDU and KARAIKAL", "STATE : TAMIL
 * NADU", "ARIYALUR", "CHENGALPATTU", "CHENNAI", "COIMBATORE", "CUDDALORE",
 * "DHARAMPURI", "DINDIGUL", "ERODE", "KALLAKURICHI", "KANCHIPURAM",
 * "KANYAKUMARI", "KARUR", "KRISHNAGIRI", "MADURAI", "NAGAPATTINAM", "NAMAKKAL",
 * "NILGIRI", "PERAMBALUR", "PUDUKKOTTAI", "RAMANATHAPURAM", "RANIPET", "SALEM",
 * "SIVAGANGA", "TENI", "TENKASI", "THANJAVUR", "THIRUVARUR", "TIRUCHIRAPPALLI",
 * "TIRUNELVELI", "TIRUPATTUR", "TIRUPPUR", "TIRUVALLUR", "TIRUVANNAMALAI",
 * "TUTICORIN", "VELLORE", "VILLUPURAM", "VIRUDHUNAGAR", "STATE : PUDUCHERRY
 * (UT)", "KARAIKAL", "MAHE", "PUDUCHERY", "SUBDIVISION : COASTAL KARNATAKA",
 * "STATE : KARNATAKA", "DAKSHIN KANNADA", "UDUPI", "UTTAR KANNADA",
 * "SUBDIVISION : N. I. KARNATAKA", "BAGALKOT", "BELGAUM", "BIDAR", "DHARWAD",
 * "GADAG", "GULBARGA", "HAVERI", "KOPPAL", "RAICHUR", "YADGIR", "SUBDIVISION :
 * S. I. KARNATAKA", "BANGALORE RURAL", "BANGLORE URBAN", "BELLARY",
 * "CHAMARAJANAGAR", "CHIKBALLAPUR", "CHIKMAGALUR", "CHITRADURGA", "DAVANGERE",
 * "HASSAN", "KODAGU", "KOLAR", "MANDHYA", "MYSORE", "RAMNAGAR", "SHIMOGA",
 * "TUMKUR", "SUBDIVISION : KERALA & MAHE", "ALAPPUZHA", "ERNAKULAM", "IDUKKI",
 * "KANNUR", "KASARGOD", "KOLLAM", "KOTTYAM", "KOZIKOD", "MALAPPURAM",
 * "PALAKKAD", "PATTANAMITTIA", "THIRUVANANTHPURAM", "TRISHUR", "WAYANAD",
 * "SUBDIVISION : LAKSHADWEEP", "LAKSHADWEEP"]
 */



function DateValidation() {
	var startDate = document.getElementById("fdate").value;
	var endDate = document.getElementById("tdate").value;

	if ((Date.parse(startDate) > Date.parse(endDate))) {
		swal({
				title : "Oops...",
				text : "End date should be greater than start date",
				icon : "error",
				timer : "200000",
				Button : "Close",
				closeModal : "true",
			})
		document.getElementById("tdate").value = "";
	}
	



}
function DateValidation1() {
	var startDate = document.getElementById("fdate1").value;
	var endDate = document.getElementById("tdate1").value;
	var startDate2 = document.getElementById("fdate2").value;
	var endDate2 = document.getElementById("tdate2").value;

	if ((Date.parse(startDate) > Date.parse(endDate))) {
		swal({
				title : "Oops...",
				text : "End date should be greater than start date",
				icon : "error",
				timer : "200000",
				Button : "Close",
				closeModal : "true",
			})
		document.getElementById("tdate1").value = "";
	}
	else if ((Date.parse(startDate2) > Date.parse(endDate2))) {
		swal({
				title : "Oops...",
				text : "End date should be greater than start date",
				icon : "error",
				timer : "200000",
				Button : "Close",
				closeModal : "true",
			})
		document.getElementById("tdate2").value = "";
	}
}

$(document).ready(function(){
	for(var i = 0; i < formNameList.length; i++){
    htmlString = htmlString+"<option value='"+ formNameList[i][0] +"'>"+ formNameList[i][1] +"</option>";
  }
  $("#formList").html(htmlString);
});



$( document ).ready(function() {
	//document.getElementById("submit_btn1").disabled = true;
	document.getElementById('loader').style.display = 'none';
	$("#formcount").hide();
	$("#datareport").hide();
	$("#dailyreport").hide();
	$('#district').prop('disabled', true);
    $('#user').prop('disabled', true);
	$.ajax({
		
		url : '/WeatherApi/StateJSONController',
		success : function(responseText) {
			
//				console.log(responseText.States);

//				//////alert(responseText.States);
			for (s in responseText.States) {
				
				$("#State1").append(
						"<option value='"+responseText.States[s]+"'>"
								+ responseText.States[s] + "</option>");
				$("#State2").append(
						"<option value='"+responseText.States[s]+"'>"
								+ responseText.States[s] + "</option>");
//					console.log(responseText.States[s]);
				$("#State3").append(
						"<option value='"+responseText.States[s]+"'>"
								+ responseText.States[s] + "</option>");
			}
		}
	});
});
$('reports').submit(function(e){
    e.preventDefault();
	if (valueTracker.statusIndex !== 0 && valueTracker.stateIndex !== 0
			&& valueTracker.startDate !== "" && valueTracker.endDate !== "") {
    	this.submit();
	} else {
		alert("Kindly select all fields!")
	}
});
	function changeListener(e, id) {
		switch (id) {
		case 'formList':
			//statusChangeListener(event);
			var elements=document.getElementById(id).options;
			
			if(e.target.selectedIndex==0)
				{
				elements[0].selected=false;
				for(var i = 0; i < elements.length; i++){
				      if(elements[i].selected)
				    	  {
				    	  valueTracker.statusIndex =i;
				    	  }
				    }
				
				}
				
			if(e.target.value==100)
				{
				
				for(var i = 0; i < elements.length; i++){
				      elements[i].selected = true;
				    }
				
				elements[1].selected=false;
				elements[0].selected=false;
				}
			break;
		case 'State1':
			valueTracker.stateIndex = e.target.selectedIndex;
			var elements=document.getElementById(id).options;
			
			if(e.target.selectedIndex==0)
			{
				elements[0].selected=false;
				for(var i = 0; i < elements.length; i++){
				      if(elements[i].selected)
				    	  {
				    	  valueTracker.statusIndex =i;
				    	  }
				    }
				
				}
			if(e.target.value=="all")
				{
				
				for(var i = 0; i < elements.length; i++){
				      elements[i].selected = true;
				    }
				elements[1].selected=false;
				elements[0].selected=false;
				}
			break;
		case 'fdate':
			valueTracker.startDate = e.target.value;
			break;
		case 'tdate':
			DateValidation();
			valueTracker.endDate = e.target.value;
			break;
		}
		//checkEnableBtn();
	}
	
	function reportchoser(e, id) {
		var elements=document.getElementById(id).options;
		if(e.target.selectedIndex==0)
		{	$("#formcount").hide();
		    $("#datareport").hide();
		    $("#dailyreport").hide();
		}
		else if(e.target.selectedIndex==1)
			{
			$("#formcount").hide();
			$("#datareport").show();
		    $("#dailyreport").hide();
			}
		else if(e.target.selectedIndex==2)
		{
			$("#formcount").show();
			$("#datareport").hide();
			$("#dailyreport").hide();
		}
		else if(e.target.selectedIndex==3)
			{
			$("#formcount").hide();
			$("#datareport").hide();
			$("#dailyreport").show();
		}
	}

	let valueTracker = {
		statusIndex : 0,
		stateIndex : 0,
		startDate : "",
		endDate : ""
	};

	function checkEnableBtn() {
		if (valueTracker.statusIndex !== 0 && valueTracker.stateIndex !== 0
				&& valueTracker.startDate !== "" && valueTracker.endDate !== "") {
			document.getElementById("submit_btn1").disabled = false;
		} else {
			document.getElementById("submit_btn1").disabled = true;
		}
	}
	
/*	$("#reports").submit(function(e) {

		document.getElementById("loader").style.display = "none";
		//e.preventDefault(); // avoid to execute the actual submit of the form.
		
	    var form = $(this);
	    var url = form.attr('action');
	    
	    
	  /* $.ajax({
	           type: "POST",
	           url: url,
	           data: form.serialize(), // serializes the form's elements.
	           beforeSend: function(){document.getElementById("loader").style.display = "none";},

	           success: function(data)
	           {
	        	   window.location.href = data;
	        	   }
	         });
	    
	});*/
	$(function(){
	    $("#State2").change(function(){
	    	$("#user").empty();
				$("#user").append(
						"<option value='all'> All </option>");
				 $('#user').prop('disabled', true);
	        if ( $("#State2").prop('selectedIndex')==0) {
	        	 $("#district option:eq(0)").prop('selected',true);
		            $("#user").prop('selectedIndex',0);
		            $("#district").empty();
						$("#district").append(
								"<option value='all'> All </option>");
	        	$('#district').prop('disabled', true);
	            $('#user').prop('disabled', true);
	           
	        }
	        else
	        	{
	        	$('#district').prop('disabled', false);
	        	 {
	 				var selectedState = $(this).children("option:selected").val();		
	 				$.ajax({
	 					url : '/WeatherApi/fetchDistrict',
	 					data:{state:selectedState},
	 					success : function(responseText) {
			
	 							$("#district").empty();
	 							$("#district").append(
	 									"<option value='all'> All </option>");
	 						for (s in responseText.district) {
	 							$("#district").append(
	 									"<option value='"+responseText.district[s]+"'>"
	 											+ responseText.district[s]
	 											+ "</option>");
//	  							
	 						}
	 					}
	 				});
	 			}
	        	}
	            
	    });
	    $("#district").change(function(){
	    	
	        if ( $("#district").prop('selectedIndex')==0) {
	        	 $("#user option:eq(0)").prop('selected',true);
		            $("#user").prop('selectedIndex',0);
		            $("#user").empty();
						$("#user").append(
								"<option value='all'> All </option>");
	            $('#user').prop('disabled', true);
	           
	        }
	        else
	        	{
	        	$('#user').prop('disabled', false);
	        	 {
	 			var selectedState = $("#State2").children("option:selected").val();
	 				var selectedDistrict = $(this).children("option:selected").val();	
	 		
	 				$.ajax({
	 					url : '/WeatherApi/fetchUserList',
	 					data:{state:selectedState,
	 						district:selectedDistrict},
	 					success : function(responseText) {
			            
	 							$("#user").empty();
	 							$("#user").append(
	 									"<option value='all'> All </option>");
	 						for (s in responseText.users) {
	 							
	 						$("#user").append(
	 								"<option value='"+responseText.users[s].userid+"'>"
	 										+ responseText.users[s].username
	 										+ "</option>");
//	  							
	 						}
	 					}
	 				});
	 			}
	        	}
	            
	    });
	});

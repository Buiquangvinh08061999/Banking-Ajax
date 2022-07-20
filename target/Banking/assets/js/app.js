class App {

   static SweetAlert = class {
       static showSuccessAlert(t) {
           Swal.fire({
               icon: 'success',
               title: t,
               position: 'top-end',
               showConfirmButton: false,
               timer: 1500
           })
       }
       static showErrorAlert(t) {
           Swal.fire({
               icon: 'error',
               title: 'Warning',
               text: t,
           })
       }

   }
    //
    // static showSuspendedConfirmDialog() {
    //     return Swal.fire({
    //         icon: 'warning',
    //         text: 'Are you sure to suspend the selected customer ?',
    //         showCancelButton: true,
    //         confirmButtonColor: '#3085d6',
    //         cancelButtonColor: '#d33',
    //         confirmButtonText: 'Yes, please suspend this client !',
    //         cancelButtonText: 'Cancel',
    //     })
    // }




}

class LocationRegion {
    constructor(id, provinceId, provinceName, districtId, districtName, wardId, wardName, address) {
        this.id = id;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.wardId = wardId;
        this.wardName = wardName;
        this.address = address;
    }
}

class Customer {
    constructor(id, fullName, email, phone, locationRegion, balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion;
        this.balance = balance;
    }
}

class Sender {
    constructor(id, fullName, email, phone, locationRegion, balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion;
        this.balance = balance;
    }
}

class Recipient {
    constructor(id, fullName, email, phone, locationRegion, balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion;
        this.balance = balance;
    }
}

class Deposit {
    constructor(customerId, fullName, balance, transactionAmount) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
    }
}

class Withdraw {
    constructor(customerId, fullName, balance, transactionAmount) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
    }
}

class Transfer {
    constructor(senderId, senderName, email, recipientId, recipientName, balance, transferAmount, fees, feesAmount, transactionAmount) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.email = email;
        this.recipientId = recipientId;
        this.recipientName = recipientName;
        this.balance = balance;
        this.transferAmount = transferAmount;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.transactionAmount = transactionAmount;
    }
}